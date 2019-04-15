package org.team.cookbook.menu.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.team.cookbook.menu.dto.IngredientInfoDTO
import org.team.cookbook.menu.model.Dish
import org.team.cookbook.menu.model.Menu
import org.team.cookbook.menu.repository.MenuRepository
import java.util.*

@Service
class MenuService {

    @Autowired
    private lateinit var dishService: DishService

    @Autowired
    private lateinit var menuRepository: MenuRepository

    fun get(menuId: String): Optional<Menu> {
        return menuRepository.findById(menuId)
    }

    fun save(menu: Menu): Menu {
        return menuRepository.save(menu)
    }

    fun addDish(menuId: String, dishId: String) {
        menuRepository.findById(menuId)
                .ifPresent { menu ->
                    menu.dishes.find { dish -> dish.id == dishId }
                            ?.let { it.count++ }
                            ?: menu.dishes.add(Dish(dishId, 1))
                    menuRepository.save(menu)
                }
    }

    fun aggregate(menuId: String): List<IngredientInfoDTO?> {
        val menu = get(menuId)
                .orElseThrow { RuntimeException("menu not found") }
        val dishIds = menu.dishes.map { dish -> dish.id }

        return dishService.getList(dishIds)
                .flatMap { it.ingredients }
                .groupBy { it?.id }
                .map { entry ->
                    val result = entry.value[0]
                    result?.weight = entry.value.sumBy { it?.weight?:0 }
                    result?.calories = entry.value.sumBy { it?.calories?:0 }
                    result
                }
    }

}
package org.team.cookbook.menu.converter

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.team.cookbook.menu.dto.DishInfoDTO
import org.team.cookbook.menu.dto.MenuInfoDTO
import org.team.cookbook.menu.model.Menu
import org.team.cookbook.menu.service.DishService

@Component
class MenuToInfoDTOConverter : Converter<Menu, MenuInfoDTO> {
    @Autowired
    private lateinit var dishService: DishService

    override fun convert(source: Menu): MenuInfoDTO {
        var dishesMap = source.dishes.map { it.id to it.count }.toMap()

        val targetDishes = dishService.getList(dishesMap.keys)
        targetDishes.forEach { it.count = dishesMap[it.id] ?: 0 }
        return MenuInfoDTO(
                source.id ?: "",
                targetDishes
        )
    }

    override fun convert(source: List<Menu>): List<MenuInfoDTO> {

        val ids = source.flatMap { it.dishes }.map { it.id }.toSet()
        val dishesMap = dishService.getList(ids).map { it.id to it }.toMap()
        return source.map {
            MenuInfoDTO(
                    it.id ?: "",
                    it.dishes
                            .map { dish ->
                                val template = dishesMap[dish.id]
                                        ?: throw RuntimeException("ingredient not found")
                                DishInfoDTO(
                                        template.id,
                                        template.name,
                                        template.description,
                                        template.calories,
                                        template.ingredients,
                                        template.image,
                                        template.preparationInstructions,
                                        dish.count
                                )
                            }
            )
        }
    }

}

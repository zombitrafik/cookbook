package org.team.cookbook.menu.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.team.cookbook.menu.model.Dish
import org.team.cookbook.menu.model.Menu
import org.team.cookbook.menu.repository.MenuRepository

@Service
class MenuService {

    @Autowired
    private lateinit var menuRepository: MenuRepository

    fun get(): List<Menu> {
        return menuRepository.findAll()
    }

    fun add(menu: Menu): Menu {
        return menuRepository.save(menu)
    }

    fun addDish(menuId: String, dishId: String) {
        menuRepository.findById(menuId)
                .ifPresent { menu ->
                    menu.dishes.find {
                        dish -> dish.id == dishId }
                            ?.let {  it.count++ }
                            ?: menu.dishes.add(Dish(dishId, 1))
                    menuRepository.save(menu)
                }
    }
}
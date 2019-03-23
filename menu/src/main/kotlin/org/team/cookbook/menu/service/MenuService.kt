package org.team.cookbook.menu.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
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
}
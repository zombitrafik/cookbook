package org.team.cookbook.menu.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.team.cookbook.menu.converter.MenuToInfoDTOConverter
import org.team.cookbook.menu.dto.MenuInfoDTO
import org.team.cookbook.menu.model.Menu
import org.team.cookbook.menu.service.MenuService


@RestController
class MenuController{

    @Autowired
    private lateinit var menuService: MenuService

    @Autowired
    private lateinit var converter: MenuToInfoDTOConverter

    @GetMapping
    fun getList(): List<MenuInfoDTO> {
        return converter.convert(menuService.get())
    }

    @PostMapping
    fun add(@RequestBody menu: Menu): MenuInfoDTO {
        return converter.convert(menuService.add(menu))
    }
}


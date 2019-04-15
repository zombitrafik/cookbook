package org.team.cookbook.menu.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.team.cookbook.menu.converter.MenuToInfoDTOConverter
import org.team.cookbook.menu.dto.IngredientInfoDTO
import org.team.cookbook.menu.dto.MenuInfoDTO
import org.team.cookbook.menu.model.Menu
import org.team.cookbook.menu.service.MenuService
import java.lang.RuntimeException


@RestController
class MenuController{

    @Autowired
    private lateinit var menuService: MenuService

    @Autowired
    private lateinit var converter: MenuToInfoDTOConverter

    @GetMapping("/{menuId}")
    fun getList(@PathVariable menuId:String): MenuInfoDTO {
        return converter.convert(menuService.get(menuId)
                .orElseThrow { RuntimeException("menu not found") }
        )
    }

    @PostMapping("/")
    fun add(@RequestBody menu: Menu): MenuInfoDTO {
        return converter.convert(menuService.save(menu))
    }

    @PostMapping("/{menuId}/{dishId}")
    fun addDish(@PathVariable menuId:String, @PathVariable dishId: String){
        menuService.addDish(menuId, dishId)
    }


    @PutMapping("/{menuId}")
    fun update(@PathVariable menuId: String, @RequestBody menu: Menu): MenuInfoDTO {
        menu.id=menuId
        return converter.convert(menuService.save(menu))
    }

    @GetMapping("/{menuId}/aggregate")
    fun aggregateIngredients(@PathVariable menuId: String): List<IngredientInfoDTO?> {
        return menuService.aggregate(menuId);
    }
}


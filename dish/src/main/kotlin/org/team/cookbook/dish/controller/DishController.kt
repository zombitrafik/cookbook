package org.team.cookbook.dish.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.team.cookbook.dish.converter.DishToInfoDTOConverter
import org.team.cookbook.dish.dto.DishInfoDTO
import org.team.cookbook.dish.model.Dish
import org.team.cookbook.dish.service.DishService


@RestController
class DishController{

    @Autowired
    private lateinit var dishService: DishService

    @Autowired
    private lateinit var dishToDTOConverter: DishToInfoDTOConverter

    @GetMapping("/list")
    fun getList(@RequestParam ids:List<String>): List<DishInfoDTO> {
        return dishToDTOConverter.convert(dishService.get(ids))
    }

    @GetMapping()
    fun getList(): List<DishInfoDTO> {
        return dishToDTOConverter.convert(dishService.get())
    }

    @PostMapping
    fun add(@RequestBody dish: Dish): DishInfoDTO {
        return dishToDTOConverter.convert(dishService.add(dish))
    }
}


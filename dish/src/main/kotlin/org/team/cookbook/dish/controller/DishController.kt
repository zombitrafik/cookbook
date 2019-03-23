package org.team.cookbook.dish.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.team.cookbook.dish.converter.DishToDTOConverter
import org.team.cookbook.dish.dto.DishDTO
import org.team.cookbook.dish.model.Dish
import org.team.cookbook.dish.service.DishService


@RestController
class DishController{

    @Autowired
    private lateinit var dishService: DishService

    @Autowired
    private lateinit var dishToDTOConverter: DishToDTOConverter

    @GetMapping
    fun getList(): List<DishDTO> {
        return dishService.get().map { dishToDTOConverter.convert(it) }
    }

    @PostMapping
    fun add(@RequestBody dish: Dish): DishDTO {
        return dishToDTOConverter.convert(dishService.add(dish))
    }
}


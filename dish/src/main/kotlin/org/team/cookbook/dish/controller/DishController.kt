package org.team.cookbook.dish.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.team.cookbook.dish.model.Dish
import org.team.cookbook.dish.service.DishService


@RestController
class DishController{

    @Autowired
    private lateinit var dishService: DishService

    @GetMapping
    fun getList(): List<Dish> {
        return dishService.get()
    }

    @PostMapping
    fun add(@RequestBody dish: Dish): Dish {
        return dishService.add(dish)
    }
}


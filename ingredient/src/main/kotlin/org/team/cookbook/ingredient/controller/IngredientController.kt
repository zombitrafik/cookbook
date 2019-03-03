package org.team.cookbook.ingredient.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.team.cookbook.ingredient.model.Ingredient
import org.team.cookbook.ingredient.service.IngredientService


@RestController
class IngredientController{

    @Autowired
    private lateinit var ingredientService: IngredientService

    @GetMapping
    fun getList(): List<Ingredient> {
        return ingredientService.get()
    }

    @PostMapping
    fun add(@RequestBody ingredient: Ingredient): Ingredient {
        return ingredientService.add(ingredient)
    }
}


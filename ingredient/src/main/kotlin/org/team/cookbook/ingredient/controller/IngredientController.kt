package org.team.cookbook.ingredient.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.team.cookbook.ingredient.model.Ingredient
import org.team.cookbook.ingredient.service.IngredientService
import java.lang.IllegalArgumentException


@RestController
class IngredientController {

    @Autowired
    private lateinit var ingredientService: IngredientService

    @GetMapping
    fun getList(@RequestParam ids:List<String>): List<Ingredient> {
        return ingredientService.get(ids)
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: String): Ingredient {
        return ingredientService.get(id)
                .orElseThrow { IllegalArgumentException("ingredient with id $id not found") }
    }

    @PostMapping
    fun add(@RequestBody ingredient: Ingredient): Ingredient {
        return ingredientService.add(ingredient)
    }


}


package org.team.cookbook.ingredient.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.team.cookbook.ingredient.model.Ingredient
import org.team.cookbook.ingredient.service.IngredientService


@RestController
class IngredientController {

    @Autowired
    private lateinit var ingredientService: IngredientService

    @GetMapping("/ipc/list")
    fun getList(@RequestParam ids:List<String>): List<Ingredient> {
        return ingredientService.get(ids)
    }

    @GetMapping("/{ingredientId}")
    fun getList(@PathVariable ingredientId:String): Ingredient {
        return ingredientService.get(ingredientId)
                .orElseThrow { RuntimeException("ingredient not found") }
    }

    @GetMapping("/")
    fun getList(): List<Ingredient> {
        return ingredientService.get()
    }

    @PostMapping("/")
    fun add(@RequestBody ingredient: Ingredient): Ingredient {
        return ingredientService.save(ingredient)
    }

    @PutMapping("/{ingredientId}")
    fun update(@PathVariable ingredientId: String, @RequestBody ingredient: Ingredient): Ingredient {
        ingredient.id=ingredientId
        return ingredientService.save(ingredient)
    }


}


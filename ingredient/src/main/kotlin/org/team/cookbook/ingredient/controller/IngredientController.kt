package org.team.cookbook.ingredient.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.team.cookbook.ingredient.dto.IngredientTableDTO
import org.team.cookbook.ingredient.model.Ingredient
import org.team.cookbook.ingredient.service.IngredientService


@RestController
class IngredientController {

    @Autowired
    private lateinit var ingredientService: IngredientService

    @GetMapping
    fun getList(@RequestParam ids:List<String> = emptyList()) = ingredientService.get(ids).map { IngredientTableDTO(it) }

    @PostMapping
    fun add(@RequestBody ingredient: Ingredient) = ingredientService.add(ingredient)
}


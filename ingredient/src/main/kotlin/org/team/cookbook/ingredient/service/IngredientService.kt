package org.team.cookbook.ingredient.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.team.cookbook.ingredient.model.Ingredient
import org.team.cookbook.ingredient.repository.IngredientRepository

@Service
class IngredientService {

    @Autowired
    private lateinit var ingredientRepository: IngredientRepository


    fun get(): List<Ingredient> {
        return ingredientRepository.findAll()
    }

    fun add(ingredient: Ingredient): Ingredient {
        return ingredientRepository.save(ingredient)
    }
}
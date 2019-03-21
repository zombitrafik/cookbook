package org.team.cookbook.ingredient.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.team.cookbook.ingredient.model.Ingredient
import org.team.cookbook.ingredient.repository.IngredientRepository
import java.util.*

@Service
class IngredientService {

    @Autowired
    private lateinit var ingredientRepository: IngredientRepository


    fun get(ids:List<String>): List<Ingredient> {
        return ingredientRepository.findAllById(ids) as List<Ingredient>
    }

    fun get(): List<Ingredient> {
        return ingredientRepository.findAll();
    }

    fun get(id: String): Optional<Ingredient> {
        return ingredientRepository.findById(id)
    }

    fun add(ingredient: Ingredient): Ingredient {
        return ingredientRepository.save(ingredient)
    }
}
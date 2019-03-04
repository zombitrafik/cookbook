package org.team.cookbook.ingredient.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.team.cookbook.ingredient.model.Ingredient
import org.team.cookbook.ingredient.repository.IngredientRepository

@Service
class IngredientService {

    @Autowired
    private lateinit var ingredientRepository: IngredientRepository


    fun get(ids: List<String>): Iterable<Ingredient> {
        return if (ids.isEmpty()){
            ingredientRepository.findAll()
        }else{
            ingredientRepository.findAllById(ids)
        }
    }

    fun add(ingredient: Ingredient) = ingredientRepository.save(ingredient)
}
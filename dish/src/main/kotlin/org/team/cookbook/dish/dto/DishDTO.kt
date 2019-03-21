package org.team.cookbook.dish.dto

data class DishDTO(
        var id: String,
        var name: String,
        var description: String,
        var calories: Int,
        var ingredients: List<IngredientDTO>
)
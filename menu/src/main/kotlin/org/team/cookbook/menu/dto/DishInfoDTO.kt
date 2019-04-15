package org.team.cookbook.menu.dto

data class DishInfoDTO(
        var id: String,
        var name: String,
        var description: String,
        var calories: Int,
        var ingredients: List<IngredientInfoDTO?>,
        var image: String,
        var preparationInstructions: String,
        var count: Int

)
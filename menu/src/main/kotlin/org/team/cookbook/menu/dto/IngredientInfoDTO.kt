package org.team.cookbook.menu.dto


data class IngredientInfoDTO(
        var id: String,
        var name: String,
        var description: String,
        var calories: Int,
        var image: String,
        var weight: Int
)
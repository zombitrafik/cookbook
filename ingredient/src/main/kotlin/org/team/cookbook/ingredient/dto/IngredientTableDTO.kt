package org.team.cookbook.ingredient.dto

import org.team.cookbook.ingredient.model.Ingredient

data class IngredientTableDTO(
        var name: String,
        var description: String,
        var calories: Int
) {
    constructor(source: Ingredient) : this(
            source.name,
            source.description,
            source.calories
    )

}
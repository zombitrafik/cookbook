package org.team.cookbook.ingredient.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Ingredient(
        @Id
        var id: String? = null,
        var name: String,
        var description: String,
        var calories: Int
)
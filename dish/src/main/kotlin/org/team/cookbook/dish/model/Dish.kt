package org.team.cookbook.dish.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Dish(
        @Id
        var id: String? = null,
        var name: String,
        var description: String,
        var calories: Int,
        var ingredients: List<Ingredient>
)
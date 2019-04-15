package org.team.cookbook.product.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Product(
        @Id
        var id: String? = null,
        var ingredientId: String,
        var name: String,
        var description: String,
        var price: Int,
        var image: String
)
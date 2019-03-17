package org.team.cookbook.dish.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

data class Ingredient(
        var id: ObjectId,
        var count: Int,
        var weight: Int
)
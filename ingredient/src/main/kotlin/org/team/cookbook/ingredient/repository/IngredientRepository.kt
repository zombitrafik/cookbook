package org.team.cookbook.ingredient.repository

import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.team.cookbook.ingredient.model.Ingredient


interface IngredientRepository: MongoRepository<Ingredient, ObjectId>
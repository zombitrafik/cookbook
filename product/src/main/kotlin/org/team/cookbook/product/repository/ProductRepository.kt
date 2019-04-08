package org.team.cookbook.product.repository

import org.springframework.data.mongodb.repository.MongoRepository
import org.team.cookbook.product.model.Product


interface ProductRepository : MongoRepository<Product, String> {
    fun findByIngredientId(ingredientId: String): List<Product>
}
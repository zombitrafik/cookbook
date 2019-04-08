package org.team.cookbook.product.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.team.cookbook.product.model.Product
import org.team.cookbook.product.repository.ProductRepository
import java.util.*

@Service
class ProductService {
    @Autowired
    private lateinit var productRepository: ProductRepository

    fun get(): List<Product> = productRepository.findAll()

    fun get(productId: String): Optional<Product> = productRepository.findById(productId)

    fun save(product: Product): Product = productRepository.save(product)


    fun findByIngredientId(ingredientId: String): List<Product>
            = productRepository.findByIngredientId(ingredientId)

}

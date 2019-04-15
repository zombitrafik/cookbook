package org.team.cookbook.product.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.team.cookbook.product.model.Product
import org.team.cookbook.product.service.ProductService

@RestController
class ProductController {

    @Autowired
    private lateinit var productService: ProductService

    @GetMapping("/")
    fun getList(@RequestParam(required = false) ingredientId: String?): List<Product> {
        return ingredientId
                ?.let { productService.findByIngredientId(it) }
                ?: productService.get()
    }

    @GetMapping("/{productId}")
    fun get(@PathVariable productId: String): Product {
        return productService.get(productId)
                .orElseThrow { RuntimeException("product not found") }
    }

    @PostMapping("/")
    fun add(@RequestBody product: Product): Product {
        return productService.save(product)
    }

    @PutMapping("/{productId}")
    fun update(@PathVariable productId: String, @RequestBody product: Product): Product {
        product.id = productId
        return productService.save(product)
    }

}
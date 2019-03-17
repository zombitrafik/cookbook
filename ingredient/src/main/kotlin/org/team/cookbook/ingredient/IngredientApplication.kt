package org.team.cookbook.ingredient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class IngredientApplication

fun main(args: Array<String>) {
	runApplication<IngredientApplication>(*args)
}

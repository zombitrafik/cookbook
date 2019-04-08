package org.team.cookbook.dish

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import springfox.documentation.swagger2.annotations.EnableSwagger2
import springfox.documentation.builders.PathSelectors
import org.springframework.web.bind.annotation.RestController
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket



@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableSwagger2
class DishApplication{
    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController::class.java))
                .paths(PathSelectors.any())
                .build()
    }
}

fun main(args: Array<String>) {
	runApplication<DishApplication>(*args)
}

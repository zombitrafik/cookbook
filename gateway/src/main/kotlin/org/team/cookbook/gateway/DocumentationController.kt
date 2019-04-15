package org.team.cookbook.gateway

import java.util.ArrayList

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import springfox.documentation.swagger.web.SwaggerResource
import springfox.documentation.swagger.web.SwaggerResourcesProvider

@Component
@Primary
@EnableAutoConfiguration
class DocumentationController : SwaggerResourcesProvider {

    override fun get(): List<SwaggerResource> {
        val resources = ArrayList<SwaggerResource>()
        resources.add(swaggerResource("ingredient-service", "/ingredients/v2/api-docs", "2.0"))
        resources.add(swaggerResource("dish-service", "/dishes/v2/api-docs", "2.0"))
        resources.add(swaggerResource("menu-service", "/menus/v2/api-docs", "2.0"))
        resources.add(swaggerResource("product-service", "/products/v2/api-docs", "2.0"))
        return resources
    }

    private fun swaggerResource(name: String, location: String, version: String): SwaggerResource {
        val swaggerResource = SwaggerResource()
        swaggerResource.name = name
        swaggerResource.location = location
        swaggerResource.swaggerVersion = version
        return swaggerResource
    }

}
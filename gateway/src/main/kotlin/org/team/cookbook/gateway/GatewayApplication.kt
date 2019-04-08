package org.team.cookbook.gateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.netflix.zuul.EnableZuulProxy
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableSwagger2
class GatewayApplication

fun main(args: Array<String>) {
	runApplication<GatewayApplication>(*args)
}

package org.team.cookbook.dish.service

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.team.cookbook.dish.dto.IngredientInfoDTO

@FeignClient("ingredient-service")
interface IngredientService {

    @RequestMapping(value = ["/{id}"], method = [RequestMethod.GET])
    fun getById(@PathVariable("id") id: String): IngredientInfoDTO

    @RequestMapping(params = ["ids"], method = [RequestMethod.GET])
    fun getList(@RequestParam("ids") ids: Collection<String>): List<IngredientInfoDTO>
}
package org.team.cookbook.menu.service

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.team.cookbook.menu.dto.DishInfoDTO

@FeignClient("dish-service")
interface DishService {

    @RequestMapping(value = ["/{id}"], method = [RequestMethod.GET])
    fun getById(@PathVariable("id") id: String): DishInfoDTO

    @RequestMapping(value = ["/ipc/list"], params = ["ids"], method = [RequestMethod.GET])
    fun getList(@RequestParam("ids") ids: Collection<String>): List<DishInfoDTO>
}
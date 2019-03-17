package org.team.cookbook.dish.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.team.cookbook.dish.model.Dish
import org.team.cookbook.dish.repository.DishRepository

@Service
class DishService {

    @Autowired
    private lateinit var dishRepository: DishRepository


    fun get(): List<Dish> {
        return dishRepository.findAll()
    }

    fun add(dish: Dish): Dish {
        return dishRepository.save(dish)
    }
}
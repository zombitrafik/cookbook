package org.team.cookbook.dish.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.team.cookbook.dish.model.Dish
import org.team.cookbook.dish.repository.DishRepository
import java.util.*

@Service
class DishService {

    @Autowired
    private lateinit var dishRepository: DishRepository

    fun get(): List<Dish> {
        return dishRepository.findAll()
    }

    fun get(id: String): Optional<Dish> {
        return dishRepository.findById(id)
    }

    fun get(ids:List<String>): List<Dish> {
        return dishRepository.findAllById(ids) as List<Dish>
    }


    fun save(dish: Dish): Dish {
        return dishRepository.save(dish)
    }
}
package org.team.cookbook.dish.repository

import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.team.cookbook.dish.model.Dish


interface DishRepository: MongoRepository<Dish, ObjectId>
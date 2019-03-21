package org.team.cookbook.dish.converter

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.team.cookbook.dish.dto.DishDTO
import org.team.cookbook.dish.model.Dish
import org.team.cookbook.dish.service.IngredientService

@Component
class DishToDTOConverter : Converter<Dish, DishDTO>{
    @Autowired
    private lateinit var ingredientService: IngredientService

    override fun convert(source: Dish): DishDTO {
        return DishDTO(
                source.id?:"",
                source.name,
                source.description,
                source.calories,
                ingredientService.getList(source.ingredients.map { it.id })
        )
    }

}

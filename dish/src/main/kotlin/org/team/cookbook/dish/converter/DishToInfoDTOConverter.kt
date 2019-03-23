package org.team.cookbook.dish.converter

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.team.cookbook.dish.dto.DishInfoDTO
import org.team.cookbook.dish.model.Dish
import org.team.cookbook.dish.service.IngredientService

@Component
class DishToInfoDTOConverter : Converter<Dish, DishInfoDTO> {
    @Autowired
    private lateinit var ingredientService: IngredientService

    override fun convert(source: Dish): DishInfoDTO {
        return DishInfoDTO(
                source.id ?: "",
                source.name,
                source.description,
                source.calories,
                ingredientService.getList(source.ingredients.map { it.id })
        )
    }

    override fun convert(source: List<Dish>): List<DishInfoDTO> {
        val ids = source.flatMap { it.ingredients }.map { it.id }.toSet()
        val ingredientsMap = ingredientService.getList(ids).map { it.id to it }.toMap()
        return source.map {
            DishInfoDTO(
                    it.id ?: "",
                    it.name,
                    it.description,
                    it.calories,
                    it.ingredients.map { ingr -> ingredientsMap[ingr.id] }
            )
        }
    }

}

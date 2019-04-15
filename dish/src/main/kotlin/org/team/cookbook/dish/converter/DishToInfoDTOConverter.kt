package org.team.cookbook.dish.converter

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.team.cookbook.dish.dto.DishInfoDTO
import org.team.cookbook.dish.dto.IngredientInfoDTO
import org.team.cookbook.dish.model.Dish
import org.team.cookbook.dish.service.IngredientService
import java.lang.RuntimeException

@Component
class DishToInfoDTOConverter : Converter<Dish, DishInfoDTO> {
    @Autowired
    private lateinit var ingredientService: IngredientService

    override fun convert(source: Dish): DishInfoDTO {
        val sourceIngredientMap = source.ingredients.map { it.id to it }.toMap()
        val ingredients = ingredientService.getList(sourceIngredientMap.keys)
        ingredients.forEach {
            it.weight = sourceIngredientMap[it.id]?.weight ?: 0
        }
        return DishInfoDTO(
                source.id ?: "",
                source.name,
                source.description,
                source.calories,
                ingredients,
                source.image,
                source.preparationInstructions
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
                    it.ingredients
                            .map { ingr ->
                                val template = ingredientsMap[ingr.id]
                                        ?: throw RuntimeException("ingredient not found")
                                IngredientInfoDTO(
                                        template.id,
                                        template.name,
                                        template.description,
                                        template.calories,
                                        template.image,
                                        ingr.weight
                                )
                            },
                    it.image,
                    it.preparationInstructions
            )
        }
    }

}

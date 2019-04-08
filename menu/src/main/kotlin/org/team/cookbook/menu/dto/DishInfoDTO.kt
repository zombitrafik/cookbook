package org.team.cookbook.menu.dto

data class DishInfoDTO(
        var id: String,
        var name: String,
        var description: String,
        var calories: Int,
        var count:Int,
        var image: String
)
package org.team.cookbook.menu.converter


interface Converter<FROM, TO>{
    fun convert(source:FROM): TO
    fun convert(source:List<FROM>): List<TO>
}
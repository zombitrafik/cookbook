package org.team.cookbook.menu.repository

import org.springframework.data.mongodb.repository.MongoRepository
import org.team.cookbook.menu.model.Menu


interface MenuRepository: MongoRepository<Menu, String>
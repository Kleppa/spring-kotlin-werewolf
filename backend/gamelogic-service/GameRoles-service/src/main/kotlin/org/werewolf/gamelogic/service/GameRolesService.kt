package org.werewolf.gamelogic.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.werewolf.gamelogic.repository.GameRolesRepository

@Service
class GameRolesService {
    @Autowired
    private lateinit var gameRolesRepository: GameRolesRepository
}

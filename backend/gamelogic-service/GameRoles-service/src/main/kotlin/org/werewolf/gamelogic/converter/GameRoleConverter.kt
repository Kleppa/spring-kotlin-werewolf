package org.werewolf.gamelogic.converter

import com.werewolf.dtos.GameRoleDto
import org.werewolf.gamelogic.entity.GameRole

class GameRoleConverter {
    companion object {
        fun transform(gameRoleDto: GameRoleDto): GameRole? {
            return null
        }
        fun transform(list: List<GameRoleDto>): List<GameRole?> = list.map { transform(it) }
        fun transform(gameRole: GameRole): GameRoleDto? = null
        fun transformEntities(listOfents: List<GameRole>): List<GameRoleDto?> = listOfents.map { transform(it) }
    }
}
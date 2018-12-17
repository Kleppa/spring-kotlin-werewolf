package org.werewolf.services.game.roles.converter

import org.werewolf.common.dtos.GameRoleDto
import org.werewolf.services.game.roles.entity.GameRole

class GameRoleConverter {
    companion object {
        fun transform(gameRoleDto: GameRoleDto): GameRole {
            return GameRole(
                    id = gameRoleDto.id,
                    name = gameRoleDto.name,
                    desc = gameRoleDto.desc,
                    team = gameRoleDto.team,
                    abilities = gameRoleDto.abilities ?: setOf()
            )
        }

        fun transform(list: List<GameRoleDto>): List<GameRole?> = list.map { transform(it) }

        fun transform(gameRole: GameRole): GameRoleDto = GameRoleDto(
                id = gameRole.id,
                name = gameRole.name,
                team = gameRole.team,
                abilities = gameRole.abilities,
                desc = gameRole.desc
        )
        fun transformEntities(listOfents: List<GameRole>): List<GameRoleDto?> = listOfents.map { transform(it) }
    }
}
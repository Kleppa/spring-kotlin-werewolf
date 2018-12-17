package org.werewolf.services.game.roles.service

import com.werewolf.common.dtos.GameRoleDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.werewolf.services.game.roles.converter.GameRoleConverter
import org.werewolf.services.game.roles.entity.GameRole
import org.werewolf.services.game.roles.repository.GameRolesRepository

@Service
class GameRolesService {
    @Autowired
    private lateinit var gameRolesRepository: GameRolesRepository
    fun findPaginated(page: Int, size: Int): Page<GameRoleDto> {
        val page =  gameRolesRepository.findAll(PageRequest(page,size))
        return page.map { gameRole: GameRole? ->  GameRoleConverter.transform(gameRole!!)}
    }

    fun findById(id: Long): GameRoleDto? {
        val data = gameRolesRepository.findById(id)
        if (data.isPresent) {
            return GameRoleConverter.transform(data.get())

        }
        return null
    }


}

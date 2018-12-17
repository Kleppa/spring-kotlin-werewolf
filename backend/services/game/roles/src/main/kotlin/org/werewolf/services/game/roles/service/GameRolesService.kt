package org.werewolf.gamelogic.service

import com.werewolf.dtos.GameRoleDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.werewolf.gamelogic.converter.GameRoleConverter
import org.werewolf.gamelogic.entity.GameRole
import org.werewolf.gamelogic.repository.GameRolesRepository
import java.util.Comparator.comparing

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

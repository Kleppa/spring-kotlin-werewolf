package org.werewolf.services.game.roles.repository

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import org.werewolf.services.game.roles.entity.GameRole

@Repository
interface GameRolesRepository: PagingAndSortingRepository<GameRole, Long>
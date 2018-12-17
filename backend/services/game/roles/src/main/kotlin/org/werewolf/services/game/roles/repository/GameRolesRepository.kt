package org.werewolf.gamelogic.repository

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import org.werewolf.gamelogic.entity.GameRole

@Repository
interface GameRolesRepository: PagingAndSortingRepository<GameRole, Long>
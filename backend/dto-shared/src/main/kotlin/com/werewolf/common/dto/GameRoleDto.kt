package com.werewolf.common.dto-shared

import io.swagger.annotations.ApiModel

@ApiModel
class GameRoleDto(
        var id: Long?,
        var name: String?,
        var desc: String?,
        var team: Int?,
        var abilities: Set<String>?
)

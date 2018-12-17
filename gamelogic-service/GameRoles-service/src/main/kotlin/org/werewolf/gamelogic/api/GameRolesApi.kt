package org.werewolf.gamelogic.api

import com.werewolf.dtos.GameRoleDto
import com.werewolf.utils.response.WrappedResponse
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.werewolf.gamelogic.service.GameRolesService

@RestController
@Api("Api for fetching Game Roles for Werewolf")
@RequestMapping(path = ["/api/roles"])
class GameRolesApi {
    @Autowired
    private lateinit var gameRolesService: GameRolesService
    @ApiOperation("Fetch list of all roles in Werewolf")
    @ApiResponses(ApiResponse(code = 200,message = "Fetched all roles"))
    @GetMapping(path = ["/"])
    fun getAllRoles():ResponseEntity<WrappedResponse<Page<GameRoleDto>>>{

        return ResponseEntity.ok().build()
    }
}
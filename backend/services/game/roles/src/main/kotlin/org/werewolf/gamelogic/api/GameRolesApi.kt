package org.werewolf.gamelogic.api

import com.werewolf.dtos.GameRoleDto
import com.werewolf.utils.response.WrappedResponse
import io.swagger.annotations.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.werewolf.gamelogic.converter.GameRoleConverter
import org.werewolf.gamelogic.entity.GameRole
import org.werewolf.gamelogic.service.GameRolesService
import java.lang.NumberFormatException

@RestController
@Api("Api for fetching Game Roles for Werewolf")
@RequestMapping(path = ["/api/roles"])
class GameRolesApi {
    @Autowired
    private lateinit var gameRolesService: GameRolesService

    @ApiOperation("Fetch list of all roles in Werewolf")
    @ApiResponses(ApiResponse(code = 200, message = "Fetched all roles"))
    @GetMapping(path = ["/"])
    fun getAllRoles(

            @ApiParam("The page - offset you want")
            @RequestParam(value = "page", defaultValue = "0", required = false) page: Int,
            @ApiParam("The amount of elements per page")

            @RequestParam(value = "size", defaultValue = "10", required = false) size: Int

    ): ResponseEntity<WrappedResponse<Page<GameRoleDto>>> {

        val page = gameRolesService.findPaginated(page, size)
        return ResponseEntity.status(200).body(WrappedResponse(code = 200, data = page, message = "Page of Game roles").validated())
    }

    @ApiOperation("Fetches a element based on id")
    @ApiResponses(ApiResponse(code = 200, message = "ok"))
    @GetMapping("/{id}")
    fun getById(
            @ApiParam("Id of the game role you want to fetch") @PathVariable("id") idFromPath: String
    ): ResponseEntity<WrappedResponse<List<GameRoleDto>>> {

        val id: Long
        try {
            id = idFromPath.toLong()
        } catch (e: NumberFormatException) {
            return ResponseEntity.status(400).body(WrappedResponse<List<GameRoleDto>>(code = 400, message = "Bad request", data = listOf()).validated())
        }
        val entity = gameRolesService.findById(id)
                ?: return ResponseEntity.status(404).body(WrappedResponse<List<GameRoleDto>>(code = 404, message = "could not find resource", data = listOf()).validated())
        val data = listOf(entity)

        return ResponseEntity.status(200).body(WrappedResponse(code = 200, message = "The requested resource", data = data).validated())
    }
}
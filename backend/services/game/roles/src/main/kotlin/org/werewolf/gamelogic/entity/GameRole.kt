package org.werewolf.gamelogic.entity

import org.hibernate.validator.constraints.Range
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity(name = "game_roles")
class GameRole(
        @get:Id
        @get:GeneratedValue
        @get:Column(name = "id")
        var id: Long? = null,
        @get:NotBlank
        @get:Size(min=1,max=160)
        var name: String? = null,
        @get:NotBlank
        @get:Size(min=1,max=999)
        var desc: String? = null,
        @get:Range(min=1,max=3)
        var team: Int? = null,

        @get:ElementCollection
        var abilities: Set<String> = setOf()
)

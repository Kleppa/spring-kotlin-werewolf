package org.werewolf.gamelogic.entity

import javax.persistence.*

@Entity
@Table(name = "Game roles")
class GameRole {
    @get:Id
    @get:GeneratedValue
    @get:Column(name = "id")
    var id:Long? = null

    var name: String? = null
    var desc: String? = null
    var team: Int? = null
    var abilities: Set<String> = setOf()
}

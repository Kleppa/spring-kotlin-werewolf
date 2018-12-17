package org.werewolf.services.game.roles

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LocalApplicationRunner {

}

fun main(args: Array<String>) {
    runApplication<LocalApplicationRunner>(*args)
}
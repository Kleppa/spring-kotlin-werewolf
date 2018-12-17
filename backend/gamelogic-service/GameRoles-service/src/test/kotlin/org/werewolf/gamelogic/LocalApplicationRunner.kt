package org.werewolf.gamelogic

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LocalApplicationRunner {

}

fun main(args: Array<String>) {
    runApplication<LocalApplicationRunner>(*args)
}
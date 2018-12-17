package org.werewolf.services.gateway.scg

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class ScgApplication

fun main(args: Array<String>) {
    runApplication<ScgApplication>(*args)
}


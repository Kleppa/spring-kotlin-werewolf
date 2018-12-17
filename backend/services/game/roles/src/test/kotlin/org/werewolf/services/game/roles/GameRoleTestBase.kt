package org.werewolf.gamelogic

import io.restassured.RestAssured
import org.junit.Before
import org.junit.Test
import org.junit.After
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [(GamerolesApplication::class)],
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GameRoleTestBase {

    @LocalServerPort
    protected var port = 0

    @Test
    fun contextLoads() {
    }
    @Before
    @After
    fun clean() {


        RestAssured.baseURI = "http://localhost"
        RestAssured.port = port
        RestAssured.basePath = "/api/roles"
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails()

//        repository.run {
//            deleteAll()
//            movieEntities.forEach {
//                save(it)
//            }
//        }
    }

}


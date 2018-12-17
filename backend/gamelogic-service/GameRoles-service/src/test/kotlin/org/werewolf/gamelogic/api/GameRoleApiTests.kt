package org.werewolf.gamelogic.api

import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.werewolf.gamelogic.GameRoleTestBase

class GameRoleApiTests: GameRoleTestBase() {
    @Test
    fun basicTest(){
        given().content(ContentType.JSON)
                .get("/")
                .then()
                .statusCode(200)
    }
}
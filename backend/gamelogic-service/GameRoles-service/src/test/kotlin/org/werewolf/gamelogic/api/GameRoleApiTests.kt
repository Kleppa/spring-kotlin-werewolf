package org.werewolf.gamelogic.api

import com.werewolf.dtos.GameRoleDto
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.Page
import org.springframework.test.context.junit4.SpringRunner
import org.werewolf.gamelogic.GameRoleTestBase

class GameRoleApiTests : GameRoleTestBase() {
    @Test
    fun basicTest() {
        val data = given()
                .content(ContentType.JSON)
                .get("/?page=2&size=5")
                .then()
                .statusCode(200)

        data.extract().jsonPath().getList("data.content", GameRoleDto::class.java).forEach{ println(it.name)}
    }
}
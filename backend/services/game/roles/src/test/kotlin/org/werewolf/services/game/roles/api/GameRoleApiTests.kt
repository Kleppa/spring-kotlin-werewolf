package org.werewolf.services.game.roles.api

import com.werewolf.common.dtos.GameRoleDto
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.junit.Test
import org.werewolf.gamelogic.GameRoleTestBase

class GameRoleApiTests : GameRoleTestBase() {
    @Test
    fun basicTest() {
        val data = given()
                .contentType(ContentType.JSON)
                .get("/?page=2&size=5")
                .then()
                .statusCode(200)

        data.extract().jsonPath().getList("data.content", GameRoleDto::class.java).forEach{ println(it.name)}
    }
}
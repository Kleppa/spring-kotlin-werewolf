package org.werewolf.services.game.roles.api

import org.werewolf.common.dtos.GameRoleDto
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.werewolf.services.game.roles.GameRoleTestBase

class GameRoleApiTests : GameRoleTestBase() {
    @Test
    fun getAllWithPagination() {
        val data = given()
                .contentType(ContentType.JSON)
                .get("/?page=2&size=5")
                .then()
                .statusCode(200)

        var extractedData = data.extract().jsonPath().getList("data.content", GameRoleDto::class.java)
        assertThat(extractedData.size,equalTo(5))
        val getBiggerBatch = given()
                .contentType(ContentType.JSON)
                .get("/?page=1&size=10")
                .then()
                .statusCode(200)
        extractedData = getBiggerBatch.extract().jsonPath().getList("data.content", GameRoleDto::class.java)
        assertThat(extractedData.size,equalTo(10))
    }
    @Test
    fun getWithId() {
        val data = given()
                .contentType(ContentType.JSON)
                .get("/1/")
                .then()
                .statusCode(200)

        var extractedData = data.extract().jsonPath().getList("data", GameRoleDto::class.java)

        assertThat(extractedData.size, equalTo(1))
        assertThat(extractedData[0].id, equalTo(1L))

        val wrongPathParam = given()
                .contentType(ContentType.JSON)
                .get("/asdf/")
                .then()
                .statusCode(400)

    }
}
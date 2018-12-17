package org.werewolf.gamelogic

import io.restassured.RestAssured
import org.junit.Before
import org.junit.Test
import org.junit.After
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.junit4.SpringRunner
import org.werewolf.gamelogic.entity.GameRole
import org.werewolf.gamelogic.repository.GameRolesRepository

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [(GamerolesApplication::class)],
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GameRoleTestBase {
    @Autowired
    protected lateinit var repository: GameRolesRepository
    @LocalServerPort
    protected var port = 0
    private val gameroleEntities = ArrayList<GameRole>()


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
        prepTestData()
    }
    fun prepTestData() {
        gameroleEntities.removeAll(gameroleEntities)

        listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 ,13 ,14 ,15 ,16 ,17 ,19, 20, 21, 22, 23, 24, 25 , 26, 27, 28, 29 , 30 ,31, 32 ,33 ,34)
                .forEach { data ->
                    gameroleEntities
                            .add(GameRole(
                                    name = "Role - $data",
                                    desc = (data * 10).toString(),
                                    abilities = setOf("Ability1","Ability2","Ability3"),
                                        team = (1..3).shuffled().first()
                            ))
                }
        repository.run {
            deleteAll()
            gameroleEntities.forEach {
                save(it)
            }
        }
    }

}


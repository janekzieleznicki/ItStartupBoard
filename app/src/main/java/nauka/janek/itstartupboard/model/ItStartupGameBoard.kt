package nauka.janek.itstartupboard.model

import io.reactivex.Observable
import java.util.*

interface ItStartupGameBoard {

    var gameStartPoints: Int

    var gameProjectPOints: Int

    val minStartPoints: Int
//        get() = 1

    val maxStartPoints: Int
//        get() = 6

    fun projectPointsList(): List<Int>

    fun addPlayer(player: Player)

    fun deletePlayer(player: Player)

    fun playerListChanges(): Observable<List<Player>>

    fun addPoints(player: Player, points: Int)

    fun numberOfPlayers(): Int
}
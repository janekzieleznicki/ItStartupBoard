package nauka.janek.itstartupboard.model

import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

class ItStartupGameBoardImpl() : ItStartupGameBoard{
    override var gameStartPoints: Int = 0

    override var gameProjectPOints: Int = 0
    override val minStartPoints: Int = 1
    override val maxStartPoints: Int = 6
    override fun addPlayer(player: Player) {
        playerList.add(player)
        playerListSubject.onNext(playerList)
    }

    override fun addPoints(player: Player, points: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private val playerList: MutableList<Player> = ArrayList()

    private var playerListSubject = BehaviorSubject.create<List<Player>>()

    override fun playerListChanges(): Observable<List<Player>> = playerListSubject

    override fun deletePlayer(player: Player) {
        playerList.remove(player)
        playerListSubject.onNext(playerList)
    }

    override fun numberOfPlayers(): Int = playerList.size

    override fun projectPointsList(): List<Int> {
        return emptyList()
    }

}

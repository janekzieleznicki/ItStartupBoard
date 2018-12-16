package nauka.janek.itstartupboard.view.scoreboard

import io.reactivex.Observable
import nauka.janek.itstartupboard.model.Player

interface ScoreBoardView {
    fun displayPlayers(playerList: List<Player>)

    fun playerChanges(): Observable<Player>
}
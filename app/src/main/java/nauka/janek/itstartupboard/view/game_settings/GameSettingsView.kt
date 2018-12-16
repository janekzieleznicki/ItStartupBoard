package nauka.janek.itstartupboard.view.game_settings

import io.reactivex.Observable
import nauka.janek.itstartupboard.model.Player

interface GameSettingsView {
    fun showPlayerList(playerList: List<Player>)

    fun useGoodPlannigChanges(): Observable<Boolean>
}
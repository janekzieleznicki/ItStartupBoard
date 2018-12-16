package nauka.janek.itstartupboard.presenter

import io.reactivex.Observable
import nauka.janek.itstartupboard.model.Player
import nauka.janek.itstartupboard.view.game_settings.GameSettingsView

interface PlayerListEditPresenter {

    val startPointsList: Array<String>

    val projectPointsList: Array<String>

    fun deletePlayer(player: Player)

    fun addPlayer(playerName: String)

    fun getNextPlayerIndex(): Int

    fun attachView(gameSettingsView: GameSettingsView)

    fun detachView()

    fun startPointsItemSelected(position: Int)
//    fun
    fun startPointsChanges(): Observable<Int>

    fun projectPointsChanges(): Observable<Int>

    fun projectPointsItemSelected(position: Int)
}
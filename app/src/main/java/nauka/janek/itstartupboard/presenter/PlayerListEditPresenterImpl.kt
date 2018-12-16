package nauka.janek.itstartupboard.presenter

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.subjects.BehaviorSubject
import nauka.janek.itstartupboard.model.ItStartupGameBoard
import nauka.janek.itstartupboard.model.Player
import nauka.janek.itstartupboard.view.game_settings.GameSettingsView
import kotlin.random.Random

class PlayerListEditPresenterImpl(
    private val itStartupGameBoard: ItStartupGameBoard
) : PlayerListEditPresenter {

    private val startPointsList = (itStartupGameBoard.minStartPoints..itStartupGameBoard.maxStartPoints).map { it.toString() }.toTypedArray()

    private var gameSettingsView: GameSettingsView? = null

    override fun startPointsList(): Array<String> = startPointsList

    override fun startPointsItemSelected(position: Int) {
        if (position >= startPointsList.size)
            itStartupGameBoard.gameStartPoints = startPointsList[Random.nextInt(0, startPointsList.size)].toInt()
        else
            itStartupGameBoard.gameStartPoints = startPointsList[position].toInt()
        startPointsSubject.onNext(itStartupGameBoard.gameStartPoints)
    }

    override fun projectPointsItemSelected(position: Int){

    }

    private val startPointsSubject = BehaviorSubject.create<Int>()
    private val projectPointsSubject= BehaviorSubject.create<Int>()

    override fun startPointsChanges() : Observable<Int> = startPointsSubject
    override fun projectPointsChanges() : Observable<Int> = projectPointsSubject

    override fun getNextPlayerIndex(): Int = itStartupGameBoard.numberOfPlayers()+1

    override fun detachView() {
        gameSettingsView = null
    }

    override fun attachView(gameSettingsView: GameSettingsView) {
        this.gameSettingsView = gameSettingsView
        bindView()
    }

    override fun deletePlayer(player: Player) {
        itStartupGameBoard.deletePlayer(player)
    }

    override fun addPlayer(playerName: String) {
        itStartupGameBoard.addPlayer(Player(playerName))
    }

    fun bindView(){
        itStartupGameBoard.playerListChanges().observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                    gameSettingsView?.showPlayerList(it)
            }
    }
}
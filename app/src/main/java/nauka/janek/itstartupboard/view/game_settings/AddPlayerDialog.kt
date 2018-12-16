package nauka.janek.itstartupboard.view.game_settings

import io.reactivex.Observable
import nauka.janek.itstartupboard.model.Player

interface AddPlayerDialog {

    fun showDialog()

    fun playerCreated(): Observable<Player>

}

package nauka.janek.itstartupboard.view.game_settings

import android.app.Activity
import android.support.v7.app.AlertDialog
import io.reactivex.Observable
import kotlinx.android.synthetic.main.add_player_dialog_layout.view.*
import nauka.janek.itstartupboard.GameBoardApplication
import nauka.janek.itstartupboard.R
import nauka.janek.itstartupboard.model.Player
import nauka.janek.itstartupboard.presenter.PlayerListEditPresenter
import javax.inject.Inject

class AddPlayerDialogImpl(private val context: Activity): AddPlayerDialog {
    @Inject
    lateinit var playerListEditPresenter: PlayerListEditPresenter

    init {
        GameBoardApplication.graph.inject(this)
    }

    override fun showDialog() {
        val builder = AlertDialog.Builder(context)
        val view = context.layoutInflater.inflate(R.layout.add_player_dialog_layout,null)
        view.editText.setText( "Player ${playerListEditPresenter.getNextPlayerIndex()}")
        builder.setView(view)
            .setTitle("New player")
            .setMessage("Enter name")
            .setPositiveButton(android.R.string.ok
            ) { dialog, which ->
                playerListEditPresenter.addPlayer(view.editText.text.toString())
            }
            .setNegativeButton(android.R.string.no
            ) { dialog, which ->
                TODO("not imlemented")
            }
        builder.create().show()
//        builder.set
    }

    override fun playerCreated(): Observable<Player> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
    }

}
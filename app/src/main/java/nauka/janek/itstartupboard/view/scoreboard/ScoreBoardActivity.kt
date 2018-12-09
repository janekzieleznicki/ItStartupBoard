package nauka.janek.itstartupboard.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.Observable
import nauka.janek.itstartupboard.GameBoardApplication
import nauka.janek.itstartupboard.R
import nauka.janek.itstartupboard.model.Player
import nauka.janek.itstartupboard.presenter.ScoreBoardPresenter
import javax.inject.Inject

class ScoreBoardActivity : AppCompatActivity(), ScoreBoardView {
    override fun displayPlayers(playerList: List<Player>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun playerChanges(): Observable<Player> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Inject
    lateinit var scoreBoardPresenter: ScoreBoardPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score_board)
        GameBoardApplication.graph.inject(this)
        startActivity(Intent(this, PlayerListEditActivity::class.java))
    }
}

package nauka.janek.itstartupboard.presenter

import nauka.janek.itstartupboard.model.ItStartupGameBoard
import nauka.janek.itstartupboard.view.scoreboard.ScoreBoardView

class ScoreBoardPresenterImpl(
    private val itStartupGameBoard: ItStartupGameBoard
) : ScoreBoardPresenter {

    private var scoreBoardView: ScoreBoardView? = null

    override fun attachView(view: ScoreBoardView) {
        scoreBoardView = view
    }

    override fun detachView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
package nauka.janek.itstartupboard.presenter

import nauka.janek.itstartupboard.view.scoreboard.ScoreBoardView

interface ScoreBoardPresenter {
    fun attachView(view: ScoreBoardView)

    fun detachView()
}
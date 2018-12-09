package nauka.janek.itstartupboard.presenter

import nauka.janek.itstartupboard.view.ScoreBoardView

interface ScoreBoardPresenter {
    fun attachView(view: ScoreBoardView)

    fun detachView()
}
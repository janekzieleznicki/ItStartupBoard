package nauka.janek.itstartupboard.di

import dagger.Module
import dagger.Provides
import nauka.janek.itstartupboard.model.ItStartupGameBoard
import nauka.janek.itstartupboard.presenter.ScoreBoardPresenter
import nauka.janek.itstartupboard.presenter.ScoreBoardPresenterImpl

@Module
class PresenterModule {

    @Provides
    fun scoreBoardPresenter(itStartupGameBoard: ItStartupGameBoard) : ScoreBoardPresenter = ScoreBoardPresenterImpl(itStartupGameBoard)

}
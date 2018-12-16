package nauka.janek.itstartupboard.di

import dagger.Module
import dagger.Provides
import nauka.janek.itstartupboard.model.ItStartupGameBoard
import nauka.janek.itstartupboard.presenter.PlayerListEditPresenter
import nauka.janek.itstartupboard.presenter.PlayerListEditPresenterImpl
import nauka.janek.itstartupboard.presenter.ScoreBoardPresenter
import nauka.janek.itstartupboard.presenter.ScoreBoardPresenterImpl
import javax.inject.Singleton

@Module
class PresenterModule {

    @Singleton
    @Provides
    fun scoreBoardPresenter(itStartupGameBoard: ItStartupGameBoard) : ScoreBoardPresenter = ScoreBoardPresenterImpl(itStartupGameBoard)

    @Singleton
    @Provides
    fun playerListEditPresenter(itStartupGameBoard: ItStartupGameBoard): PlayerListEditPresenter = PlayerListEditPresenterImpl(itStartupGameBoard)
}
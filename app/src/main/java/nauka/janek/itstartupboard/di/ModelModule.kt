package nauka.janek.itstartupboard.di

import dagger.Module
import dagger.Provides
import nauka.janek.itstartupboard.model.ItStartupGameBoard
import nauka.janek.itstartupboard.model.ItStartupGameBoardImpl
import javax.inject.Singleton

@Module
class ModelModule {

    @Singleton
    @Provides
    fun itStartupGameBoard() : ItStartupGameBoard = ItStartupGameBoardImpl()

}
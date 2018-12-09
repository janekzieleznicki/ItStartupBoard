package nauka.janek.itstartupboard.di

import dagger.Module
import dagger.Provides
import nauka.janek.itstartupboard.model.ItStartupGameBoard

@Module
class ModelModule {

    @Provides
    fun itStartupGameBoard() : ItStartupGameBoard = ItStartupGameBoard()

}
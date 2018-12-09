package nauka.janek.itstartupboard.di

import dagger.Component
import nauka.janek.itstartupboard.view.ScoreBoardView
import javax.inject.Singleton


@Component(modules = [ModelModule::class, PresenterModule::class])
@Singleton
interface Graph {

    fun inject(scoreBoardView: ScoreBoardView)

}
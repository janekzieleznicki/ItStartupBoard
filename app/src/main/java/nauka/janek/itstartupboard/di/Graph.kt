package nauka.janek.itstartupboard.di

import dagger.Component
import nauka.janek.itstartupboard.view.game_settings.AddPlayerDialogImpl
import nauka.janek.itstartupboard.view.game_settings.GameSettingsActivity
import nauka.janek.itstartupboard.view.scoreboard.ScoreBoardActivity
import javax.inject.Singleton


@Component(modules = [ModelModule::class, PresenterModule::class])
@Singleton
interface Graph {

    fun inject(scoreBoardActivity: ScoreBoardActivity)

    fun inject(playerListEditActivity: GameSettingsActivity)

    fun inject(addPlayerDialog: AddPlayerDialogImpl)
}
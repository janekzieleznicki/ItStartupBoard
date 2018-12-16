package nauka.janek.itstartupboard.view.game_settings

import nauka.janek.itstartupboard.model.Player

interface GameSettingsView {
    fun showPlayerList(playerList: List<Player>)
}
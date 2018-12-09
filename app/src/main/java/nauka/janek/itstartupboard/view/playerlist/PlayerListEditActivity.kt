package nauka.janek.itstartupboard.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_player_list_edit.*
import nauka.janek.itstartupboard.R
import nauka.janek.itstartupboard.model.Player
import nauka.janek.itstartupboard.view.playerlist.PlayerListAdapter

class PlayerListEditActivity : AppCompatActivity() {

    private val playerList : List<Player> = listOf(Player("John"), Player("Not John"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_list_edit)
        playerRecyclerView.layoutManager = LinearLayoutManager(this)
        playerRecyclerView.adapter = PlayerListAdapter(playerList)
    }
}

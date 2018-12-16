package nauka.janek.itstartupboard.view.game_settings

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.player_edit_item.view.*
import nauka.janek.itstartupboard.R
import nauka.janek.itstartupboard.model.Player

class PlayerListAdapter(
    private val playerList: List<Player>,
    private val listener : (Player) -> Unit
)
    : RecyclerView.Adapter<PlayerListAdapter.PlayerViewHolder>() {

    override fun onCreateViewHolder(parentGroup: ViewGroup, index: Int) = PlayerViewHolder(
        LayoutInflater.from(parentGroup.context).inflate(R.layout.player_edit_item,parentGroup,false)
    )
    override fun getItemCount() = playerList.size

    override fun onBindViewHolder(playerViewHolder: PlayerViewHolder, index: Int) {
        playerViewHolder.bind(player = playerList[index])
    }

    inner class PlayerViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        fun bind(player: Player){
            view.playerName.text = player.name
            view.deletePlayerFromListButton.setOnClickListener{
                listener(player)
            }
        }
    }
}
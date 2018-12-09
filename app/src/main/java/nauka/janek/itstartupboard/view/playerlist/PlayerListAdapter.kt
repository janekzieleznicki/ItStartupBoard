package nauka.janek.itstartupboard.view.playerlist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import nauka.janek.itstartupboard.model.Player

class PlayerListAdapter(
    private val playerList: List<Player>
)
    : RecyclerView.Adapter<PlayerListAdapter.PlayerViewHolder>() {

    override fun onCreateViewHolder(parentGroup: ViewGroup, index: Int) = PlayerViewHolder(
        LayoutInflater.from(parentGroup.context).inflate(android.R.layout.simple_list_item_1,parentGroup,false)
    )
    override fun getItemCount() = playerList.size

    override fun onBindViewHolder(playerViewHolder: PlayerViewHolder, index: Int) {
        playerViewHolder.bind(player = playerList[index])
    }

    inner class PlayerViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        fun bind(player: Player){
            with(view as TextView){
                text = player.name
            }
        }
    }
}
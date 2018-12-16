package nauka.janek.itstartupboard.view.game_settings

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_player_list_edit.*
import nauka.janek.itstartupboard.GameBoardApplication
import nauka.janek.itstartupboard.R
import nauka.janek.itstartupboard.model.Player
import nauka.janek.itstartupboard.presenter.PlayerListEditPresenter
import javax.inject.Inject

class GameSettingsActivity : AppCompatActivity(), GameSettingsView {
    override fun showPlayerList(playerList: List<Player>) {
        playerRecyclerView.adapter = PlayerListAdapter(playerList, playerListEditPresenter::deletePlayer)
    }

    @Inject
    lateinit var playerListEditPresenter: PlayerListEditPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_list_edit)
        GameBoardApplication.graph.inject(this)
        playerListEditPresenter.attachView(this)

        val startPointsOptions = playerListEditPresenter.startPointsList().toMutableList()
        startPointsOptions.add("Random")
        startPointsSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, startPointsOptions)
        playerListEditPresenter.startPointsChanges().observeOn(AndroidSchedulers.mainThread()).subscribe{
            startPointsSpinner.setSelection(startPointsOptions.indexOf(it.toString()))
        }

        startPointsSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                playerListEditPresenter.startPointsItemSelected(startPointsOptions.size)
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                playerListEditPresenter.startPointsItemSelected(position)
            }
        }



        playerRecyclerView.layoutManager = LinearLayoutManager(this)

        floatingActionButton.setOnClickListener{
            AddPlayerDialogImpl(this).showDialog()
        }
    }
}

package nauka.janek.itstartupboard.view.game_settings

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.jakewharton.rxbinding2.widget.checkedChanges
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_player_list_edit.*
import nauka.janek.itstartupboard.GameBoardApplication
import nauka.janek.itstartupboard.R
import nauka.janek.itstartupboard.model.Player
import nauka.janek.itstartupboard.presenter.GameSettingsPresenter
import javax.inject.Inject

class GameSettingsActivity : AppCompatActivity(), GameSettingsView {
    override fun useGoodPlannigChanges(): Observable<Boolean> =
        useGoodPlanningSwitch.checkedChanges()
            .skipInitialValue()

    override fun showPlayerList(playerList: List<Player>) {
        playerRecyclerView.adapter = PlayerListAdapter(playerList, gameSettingsPresenter::deletePlayer)
    }

    @Inject
    lateinit var gameSettingsPresenter: GameSettingsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_list_edit)
        GameBoardApplication.graph.inject(this)
        gameSettingsPresenter.attachView(this)

        setUpStartPointsSpinner()
        setUpProjectPointsSpinner()
        useGoodPlanningSwitch

        playerRecyclerView.layoutManager = LinearLayoutManager(this)

        floatingActionButton.setOnClickListener{
            AddPlayerDialogImpl(this).showDialog()
        }
    }

    private fun setUpProjectPointsSpinner() {
        val projectPointsOPtions = gameSettingsPresenter.projectPointsList.toMutableList()
        projectPointsOPtions.add("Random")
        projectPointsSpinner.adapter =
                ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, projectPointsOPtions)
        gameSettingsPresenter.projectPointsChanges().observeOn(AndroidSchedulers.mainThread()).subscribe {
            projectPointsSpinner.setSelection(projectPointsOPtions.indexOf(it.toString()))
        }

        projectPointsSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                gameSettingsPresenter.projectPointsItemSelected(projectPointsOPtions.size)
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                gameSettingsPresenter.projectPointsItemSelected(position)
            }
        }
    }

    private fun setUpStartPointsSpinner() {
        val startPointsOptions = gameSettingsPresenter.startPointsList.toMutableList()
        startPointsOptions.add("Random")
        startPointsSpinner.adapter =
                ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, startPointsOptions)
        gameSettingsPresenter.startPointsChanges().observeOn(AndroidSchedulers.mainThread()).subscribe {
            startPointsSpinner.setSelection(startPointsOptions.indexOf(it.toString()))
        }

        startPointsSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                gameSettingsPresenter.startPointsItemSelected(startPointsOptions.size)
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                gameSettingsPresenter.startPointsItemSelected(position)
            }
        }
    }
}

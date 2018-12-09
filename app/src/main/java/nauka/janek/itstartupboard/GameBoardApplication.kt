package nauka.janek.itstartupboard

import android.app.Application
import nauka.janek.itstartupboard.di.Graph
import nauka.janek.itstartupboard.di.DaggerGraph

class GameBoardApplication: Application() {

    companion object {
        lateinit var graph: Graph
    }

    override fun onCreate() {
        super.onCreate()
        graph = DaggerGraph.builder()
            .build()
    }
}
package nauka.janek.itstartupboard.model

import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

class Player(
    val name: String,
    var totalScore: Int = 0,
    var scoreList: MutableList<Int> = ArrayList<Int>(12)
) {
    private val scoreChangesSubject = BehaviorSubject.create<Int>()
    private val scoreListChangesSubject = BehaviorSubject.create<List<Int>>()

    fun addPoints(points: Int){
        scoreList.add(points)
        scoreListChangesSubject.onNext(scoreList)

        totalScore += points
        scoreChangesSubject.onNext(totalScore)
    }

    fun scoreChanges(): Observable<Int> = scoreChangesSubject

    fun scoreListChanges(): Observable<List<Int>> = scoreListChangesSubject
}
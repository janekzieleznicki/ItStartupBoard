package nauka.janek.itstartupboard

import nauka.janek.itstartupboard.model.Player
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource


class PlayerTest {

    private val player = Player("Johnny")

    companion object {
        @JvmStatic
        fun arguments() = listOf(
            Arguments.of(listOf(1, 2, 3)),
            Arguments.of(listOf(2, 3, 5)),
            Arguments.of(listOf(11, 23, 34)),
            Arguments.of(listOf(10, 20, 30))
        )
    }
    @ParameterizedTest
    @MethodSource("arguments")
    fun added_points_should_notify(inputs: List<Int>){
        val result = inputs.last()
        val points = inputs.dropLast(1)
        var totalScore = 0
        player.scoreChanges().subscribe{
            totalScore = it
        }
        points.forEach{
            player.addPoints(it)
        }
        Assertions.assertEquals(result, totalScore)
    }
    @ParameterizedTest
    @MethodSource("arguments")
    fun added_points_should_notify_with_list(inputs: List<Int>){
        val points = inputs.dropLast(1)
        var point_list: List<Int> = ArrayList<Int>()
        player.scoreListChanges().subscribe{
            point_list = it
        }
        points.forEach{
            player.addPoints(it)
        }
        Assertions.assertArrayEquals(points.toIntArray(), point_list.toIntArray())
    }
}
package org.example.bowlingkata

sealed class Frame(val rollCount: Int, private val bonusCount: Int) {
    fun score(rolls: List<Int>): Int = rolls.take(rollCount + bonusCount).sum()

    object Strike: Frame(1, 2)
    class Spare(val firstRoll: Int , val secondRoll: Int): Frame(2, 1)
    class Open(val firstRoll: Int , val secondRoll: Int): Frame(2, 0)

    companion object {
        fun from(rolls: List<Int>): Frame = when {
            rolls[0] == 10 -> Strike
            rolls[0] + rolls[1] == 10 -> Spare(rolls[0], rolls[1])
            else -> Open(rolls[0], rolls[1])
        }
    }
}

fun score(rolls: List<Int>): Int  {
    var total = 0
    var rest = rolls

    repeat(10) {
        val frame = Frame.from(rest)
        total += frame.score(rest)
        rest = rest.drop(frame.rollCount)
    }
    return total
}
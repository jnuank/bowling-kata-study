package org.example.bowlingkata

sealed interface Frame2 {
    fun score(): Int
    fun firstPins(): Int
    fun firstTwoPins(): Int
}

class Strike(private val next: Frame2) : Frame2 {
    override fun score(): Int = 10 + next.firstTwoPins() + next.score()

    override fun firstPins(): Int = 10

    override fun firstTwoPins(): Int = 10 + next.firstPins()

}

class Spare(private val first: Int, val next: Frame2) : Frame2 {
    override fun score(): Int = 10 + next.firstPins() + next.score()

    override fun firstPins(): Int = first

    override fun firstTwoPins(): Int = 10

}

class Open(private val first: Int, private val second: Int, val next: Frame2) : Frame2 {
    override fun score(): Int = first + second + next.score()

    override fun firstPins(): Int = first

    override fun firstTwoPins(): Int = first + second

}

class Bonus(private val rolls: List<Int>) : Frame2 {
    override fun score(): Int = 0

    override fun firstPins(): Int = rolls.take(1).sum()

    override fun firstTwoPins(): Int = rolls.take(2).sum()
}

private fun parse(rolls: List<Int>, frameNo: Int = 1): Frame2 = when {
    frameNo > 10 -> Bonus(rolls)
    rolls[0] == 10 -> Strike(parse(rolls.drop(1), frameNo + 1))
    rolls[0] + rolls[1] == 10 -> Spare(rolls[0], parse(rolls.drop(2), frameNo + 1))
    else -> Open(rolls[0], rolls[1], parse(rolls.drop(2), frameNo + 1))
}

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
    return parse(rolls).score()
}
package org.example.bowlingkata

sealed interface Frame {
    val next: Frame?
    fun score(): Int
    fun firstPins(): Int
    fun firstTwoPins(): Int
}

class Strike(override val next: Frame) : Frame {
    override fun score(): Int = 10 + next.firstTwoPins()
    override fun firstPins(): Int = 10
    override fun firstTwoPins(): Int = 10 + next.firstPins()
}

class Spare(private val first: Int, override val next: Frame) : Frame {
    override fun score(): Int = 10 + next.firstPins()
    override fun firstPins(): Int = first
    override fun firstTwoPins(): Int = 10
}

class Open(private val first: Int, private val second: Int, override val next: Frame) : Frame {
    override fun score(): Int = first + second
    override fun firstPins(): Int = first
    override fun firstTwoPins(): Int = first + second
}

class Bonus(private val rolls: List<Int>) : Frame {
    override val next: Frame? = null
    override fun score(): Int = 0
    override fun firstPins(): Int = rolls.take(1).sum()
    override fun firstTwoPins(): Int = rolls.take(2).sum()
}

 fun parse(rolls: List<Int>, frameNo: Int = 1): Frame = when {
    frameNo > 10 -> Bonus(rolls)
    rolls[0] == 10 -> Strike(parse(rolls.drop(1), frameNo + 1))
    rolls[0] + rolls[1] == 10 -> Spare(rolls[0], parse(rolls.drop(2), frameNo + 1))
    else -> Open(rolls[0], rolls[1], parse(rolls.drop(2), frameNo + 1))
}

fun score(rolls: List<Int>): Int  = generateSequence(parse(rolls)) { it.next }.sumOf { it.score() }

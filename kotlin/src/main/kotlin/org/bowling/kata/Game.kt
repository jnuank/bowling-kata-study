package org.bowling.kata

class Game {
    companion object {
        fun score(listOf: List<Int>): Int {
            return 0
        }
    }
}

data class FramePerRolls(private val rolls: List<Int>) {
    companion object {
        fun from(rolls: List<Int>): Pair<FramePerRolls, List<Int>> {
            if (rolls.size <= 3) {
                return Pair(FramePerRolls(rolls), emptyList())
            } else if (rolls.first() == 10) {
                return FramePerRolls(rolls.take(3)) to rolls.drop(1)
            } else if (rolls.take(2).sum() == 10) {
                return FramePerRolls(rolls.take(3)) to rolls.drop(2)
            } else {
                return FramePerRolls(rolls.take(2)) to rolls.drop(2)

            }

        }
    }

    fun score(): Int {
        return rolls.sum()
    }

}

class Frames(val values: List<FramePerRolls>) : Iterable<FramePerRolls> {
    companion object {
        fun from(rolls: List<Int>): Frames {
            val list = mutableListOf<FramePerRolls>()
            var remaining = rolls
            while (remaining.isNotEmpty()) {
                val (frame, rest) = FramePerRolls.from(remaining)
                list.add(frame)
                remaining = rest
            }
            return Frames(list)
        }
    }

    override operator fun iterator(): Iterator<FramePerRolls> = values.iterator()
}

fun score(rolls: List<Int>): Int {
    return Frames.from(rolls)
        .sumOf { it.score() }
}
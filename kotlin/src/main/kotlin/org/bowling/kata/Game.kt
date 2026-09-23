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
            if(rolls.first() == 10) {
                return FramePerRolls(rolls.take(3)) to rolls.drop(1)
            }

            if(rolls.take(2).sum() == 10) {
                return FramePerRolls(rolls.take(3)) to rolls.drop(2)
            }

            return FramePerRolls(rolls.take(2)) to rolls.drop(2)
        }
    }

    fun score(): Int {
        return rolls.sum()
    }

}

class Frames(val values: List<FramePerRolls>): Iterable<FramePerRolls> {
    companion object {
        fun from(rolls: List<Int>): Frames {
            val list = mutableListOf<FramePerRolls>()
            var remaining = rolls
            while (remaining.isNotEmpty()) {
                val (frame, restRolls) = FramePerRolls.from(rolls)
                list.add(frame)
                remaining = restRolls
            }

            return Frames(list)
        }
    }

    override operator fun iterator(): Iterator<FramePerRolls> = values.iterator()
}
fun score(rolls: List<Int>): Int {
    var total = 0
    var index = 0

    // frameという概念に変換

    // frameをforeachして処理する。

    val frames = Frames.from(rolls)
    for (frame in frames) {
        total += frame.score()
    }

//    while (index < rolls.size) {
//        if(rolls.size - index == 3){
//            total += rolls[index] + rolls[index + 1] + rolls[index + 2]
//            index += 3
//            continue
//        }
//
//        if(10 == rolls[index]){
//            total += rolls[index] + rolls[index + 1] + rolls[index + 2]
//            index ++
//            continue
//        }
//
//        if(10 == rolls[index] + rolls[index+1]){
//            total += 10 + rolls[index+2]
//            index +=2
//            continue
//        }
//
//        total += rolls[index] + rolls[index+1]
//        index +=2
//    }

    return total
}
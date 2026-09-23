package org.bowling.kata

class Game {
    companion object {
        fun score(listOf: List<Int>): Int {
            return 0
        }
    }
}

class Frame(rolls: List<Int>) {
    companion object {
        fun from(rolls: List<Int>): Pair<Frame, List<Int>> {
            TODO()
        }
    }

    fun score(): Int {
        TODO("Not yet implemented")
    }

}

class Frames(val values: List<Frame>): Iterable<Frame> {
    companion object {
        fun from(rolls: List<Int>): Frames {
            TODO()
        }
    }

    override operator fun iterator(): Iterator<Frame> = values.iterator()
}
fun score(rolls: List<Int>): Int {
    var total = 0
    var index = 0

    // frameという概念に変換

    // frameをforeachして処理する。

//    val frames = Frames.from(rolls)
//    for (frame in frames) {
//        total += frame.score()
//    }

    while (index < rolls.size) {
        if(rolls.size - index == 3){
            total += rolls[index] + rolls[index + 1] + rolls[index + 2]
            index += 3
            continue
        }

        if(10 == rolls[index]){
            total += rolls[index] + rolls[index + 1] + rolls[index + 2]
            index ++
            continue
        }

        if(10 == rolls[index] + rolls[index+1]){
            total += 10 + rolls[index+2]
            index +=2
            continue
        }

        total += rolls[index] + rolls[index+1]
        index +=2
    }

    return total
}
package org.example.bowlingkata

sealed class Frame {
    data class Spare(private val firstRoll: Int, private val secondRoll: Int) : Frame() {
        override fun score(nextFrame: Frame): Int {
            return firstRoll + secondRoll
        }
    }

    data class Open(private val firstRoll: Int, private val secondRoll: Int) : Frame() {
        override fun score(nextFrame: Frame): Int {
            return firstRoll + secondRoll
        }
    }

    companion object {
        fun from(firstRoll: Int, secondRoll: Int): Frame {
            return if(firstRoll + secondRoll == 10) {
                Spare(firstRoll, secondRoll)
            } else {
                Open(firstRoll, secondRoll)
            }
        }


    }
    abstract fun score(nextFrame: Frame): Int
}


fun score(rolls: List<Int>): Int  {
    var total = 0
    var index = 0
    while (index < rolls.size) {
        val frame = Frame.from(rolls[index], rolls[index+1])
        total += frame.score(Frame.from(rolls[index+2], rolls[index+3]))
        index += 2
//            total += rolls[index] + rolls[index+1] + rolls[index+2]
//            index += 2
//        } else {
//            total += rolls[index] + rolls[index+1]
//            index += 2
//        }
    }
    return total
}
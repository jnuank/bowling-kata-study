package org.bowling.kata

class Game {
    companion object {
        fun score(listOf: List<Int>): Int {
            return 0
        }
    }

}

fun score(rolls: List<Int>): Int {
    var total = 0
    var index = 0
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
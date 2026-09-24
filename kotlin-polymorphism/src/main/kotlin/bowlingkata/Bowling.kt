package org.example.bowlingkata

fun score(rolls: List<Int>): Int  {
    var total = 0
    var index = 0
    while (index < rolls.size) {
        if(rolls[index] + rolls[index+1] == 10) {
            total += rolls[index] + rolls[index+1] + rolls[index+2]
            index += 2
        } else {
            total += rolls[index] + rolls[index+1]
            index += 2
        }
    }
    return total
}
package org.bowling.kata

data class ScoringRolls(private val rolls: List<Int>) {
    companion object {
        fun from(rolls: List<Int>): Pair<ScoringRolls, List<Int>> {
            if (rolls.size <= 3) {
                return Pair(ScoringRolls(rolls), emptyList())
            } else if (rolls.first() == 10) {
                return ScoringRolls(rolls.take(3)) to rolls.drop(1)
            } else if (rolls.take(2).sum() == 10) {
                return ScoringRolls(rolls.take(3)) to rolls.drop(2)
            } else {
                return ScoringRolls(rolls.take(2)) to rolls.drop(2)
            }
        }
    }

    fun score(): Int {
        return rolls.sum()
    }

}

// なんでもファーストクラスコレクションにする必要は無いと思った。
// どうせframes.valuesみたいに取り出すんだったら、それでいいか
// equalsが欲しいというパターンはあるかもだけど

fun scoringRollsOf(rolls: List<Int>): List<ScoringRolls> {
    val list = mutableListOf<ScoringRolls>()
    var remaining = rolls
    while (remaining.isNotEmpty()) {
        val (frame, rest) = ScoringRolls.from(remaining)
        list.add(frame)
        remaining = rest
    }
    return list
}

fun score(rolls: List<Int>): Int {
    return scoringRollsOf(rolls)
        .sumOf { it.score() }
}
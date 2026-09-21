package org.bowling.kata

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe


class GameTest: StringSpec({
    "すべてガーター" {
        val score = Game.score(listOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0))

        score shouldBe 0
    }
})
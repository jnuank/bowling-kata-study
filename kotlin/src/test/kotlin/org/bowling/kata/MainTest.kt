package org.bowling.kata

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe


class GameTest: StringSpec({
    "すべてガーター" {
        val score = score(listOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0))

        score shouldBe 0
    }

    "1フレームが4と5。後はガーター" {
        val score = score(listOf(4, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0))

        score shouldBe 9
    }

})
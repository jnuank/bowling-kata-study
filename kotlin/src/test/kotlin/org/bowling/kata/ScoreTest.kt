package org.bowling.kata

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe


class ScoreTest : StringSpec({
    "すべてガーター" {

        val score = score(List(20) { 0 })

        score shouldBe 0
    }

    "1フレームが4と5。後はガーター" {
        val score = score(listOf(4, 5) + List(18) { 0 })

        score shouldBe 9
    }

    "1フレーム目がスペア、2フレーム目が4と5。後はガーター" {
        val score = score(listOf(4, 6, 4, 5) + List(16) { 0 })

        score shouldBe 23
    }
})
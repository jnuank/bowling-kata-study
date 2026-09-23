package org.bowling.kata

import io.kotest.core.spec.style.FreeSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe


class GameTest : StringSpec({
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

    "すべてスペア" {
        val score = score(List(21) { 5 })
        score shouldBe 150
    }

    "1フレーム目がストライク、2フレーム目が4と5。後はガーター" {
        val score = score(listOf(10, 4, 5) + List(17) { 0 })
        score shouldBe 28
    }
})

class FramePerRollsTest : FreeSpec({
    "生成" - {
        "全部ガーターの場合" {
            val (frame, rolls) = FramePerRolls.from(List(20) { 0 })

            frame shouldBe FramePerRolls(listOf(0, 0))
            rolls shouldBe List(18) { 0 }
        }

        "ストライクの場合" {
            val (frame, rolls) = FramePerRolls.from(listOf(10) + List(19) { 0 })

            frame shouldBe FramePerRolls(listOf(10, 0, 0))
            rolls shouldBe List(19) { 0 }
        }

        "スペアの場合" {
            val (frame, rolls) = FramePerRolls.from(listOf(5, 5) + List(18) { 0 })

            frame shouldBe FramePerRolls(listOf(5, 5, 0))
            rolls shouldBe List(18) { 0 }
        }

        "最後3投以下なら残りrollsはemptyにしてそのまま返す" {
            val (frame, rolls) = FramePerRolls.from(List(3) { 0 })

            frame shouldBe FramePerRolls(listOf(0, 0, 0))
            rolls shouldBe emptyList()

            val (frame2, rolls2) = FramePerRolls.from(List(2) { 0 })

            frame2 shouldBe FramePerRolls(listOf(0, 0))
            rolls2 shouldBe emptyList()
        }
    }

    "score" - {
        "ガーター" {
            FramePerRolls(listOf(0,0)).score() shouldBe 0
        }
        "スペア" {
            FramePerRolls(listOf(5,5,4)).score() shouldBe 14
        }
    }
})
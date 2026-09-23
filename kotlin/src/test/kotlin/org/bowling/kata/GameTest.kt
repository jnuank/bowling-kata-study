package org.bowling.kata

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import jdk.internal.net.http.common.Log.frames


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

class FrameTest : StringSpec({
    "Frame生成" {
        val (frame, rolls) = Frame.from(List(20) { 0 })

        frame shouldBe listOf(0,0)
        rolls shouldBe List(18) { 0 }
    }
})
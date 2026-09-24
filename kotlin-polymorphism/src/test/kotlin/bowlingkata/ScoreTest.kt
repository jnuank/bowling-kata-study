package bowlingkata

import io.kotest.core.spec.style.FunSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.example.bowlingkata.score

class MainTest : StringSpec({
    "すべてガーター" {
        score(List(20){0}) shouldBe 0
    }

    "1フレームだけスペア" {
        score(listOf(5,5, 4) + List(17){0}) shouldBe 18
    }
})

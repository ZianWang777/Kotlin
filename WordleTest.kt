import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.io.File

@Suppress("unused")
class WordleTest : StringSpec({

    "isValid should return true for 5 letters" {
        isValid("apple") shouldBe true
        isValid("applE") shouldBe true
        isValid("apples") shouldBe false
        isValid("app") shouldBe false
        isValid("app1e") shouldBe false
    }

    "readWordList should read valid words from file" {
        val file = File.createTempFile("words", ".txt")
        file.writeText("apple\npear\norange\n")
        val list = readWordList(file.absolutePath)
        list.size shouldBe 1
        list[0] shouldBe "apple"
    }

    "pickRandomWord should return a word from the list" {
        val words = mutableListOf("alpha", "bravo", "charlie")
        val word = pickRandomWord(words)
        listOf("alpha", "bravo", "charlie").contains(word) shouldBe true
    }

    "evaluateGuess should mark correct positions as 1" {
        val result = evaluateGuess("apple", "ample")
        result shouldBe listOf(1, 0, 1, 1, 1)
    }
})

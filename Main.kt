import kotlin.system.exitProcess

fun main() {
    val words = readWordList("data/words.txt")

    val target = pickRandomWord(words)
    println("welcome to Wordle！")
    println("Please guess 5 letter words, you have 10 chances!\n")

    var attempt = 1
    val maxAttempts = 10

    while (attempt <= maxAttempts) 
    {
        val guess = obtainGuess(attempt)

        val matches = evaluateGuess(guess, target)
        displayGuess(guess, matches)

        if (guess == target) {
            println("Congratulations! You guessed the word in $attempt attempt(s).")
            return
        }
        attempt++
    }

    println("\n gg! \n The correct word was '$target'.")
}

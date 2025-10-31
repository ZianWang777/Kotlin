private const val WORD_LENGTH = 5
private const val MAX_ATTEMPTS = 10

fun main() {
    val words = readWordList("data/words.txt")

    val target = pickRandomWord(words)
    println("Welcome to Wordle!")
    println("Please guess $WORD_LENGTH-letter words, you have $MAX_ATTEMPTS chances!\n")

    var attempt = 1

    while (attempt <= MAX_ATTEMPTS) {
        val guess = obtainGuess(attempt)

        if (guess.length != WORD_LENGTH) {
            println("Input must be $WORD_LENGTH letters. Try again.")
            continue
        }

        val matches = evaluateGuess(guess, target)
        displayGuess(guess, matches)

        if (guess == target) {
            println("Congratulations! You guessed the word in $attempt attempt.")
            return
        }
        attempt++
    }

    println("\nGG!\nThe correct word was '$target'.")
}

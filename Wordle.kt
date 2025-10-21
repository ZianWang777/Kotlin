import java.io.File
import kotlin.random.Random

fun isValid(word: String): Boolean 
{
    var b=true
    for (i in word)
        if(!i.isLetter())
        {
            b=false
        }
    if (word.length!=5)
        b=false
    return b
}

fun readWordList(filename: String): MutableList<String> 
{
    val words = mutableListOf<String>()
    val file = File(filename)
    for (line in file.readLines()) {
        val word = line.lowercase()
        if (isValid(word)) words.add(word)
    }   
    return words
}

fun pickRandomWord(words: MutableList<String>): String 
{
    val index = Random.nextInt(words.size)
    return words[index]
}

fun obtainGuess(attempt: Int): String 
{
    while (true) 
    {
        print("Attempt $attempt: ")
        val guess = readLine()!!.trim().lowercase()
        if (isValid(guess)) return guess
        println("Invalid input. Please enter a 5-letter word.")
    }
}


fun evaluateGuess(guess: String, target: String): List<Int> {
    val result = mutableListOf<Int>()
    for (i in guess.indices) {
        if (i < target.length && guess[i] == target[i]) {
            result.add(1)
        } else {
            result.add(0)
        }
    }
    return result
}

fun displayGuess(guess: String, matches: List<Int>) {
    for (i in guess.indices) {
        if (matches[i] == 1) {
            print(guess[i])
        } else {
            print("?")
        }
    }
    println()
}

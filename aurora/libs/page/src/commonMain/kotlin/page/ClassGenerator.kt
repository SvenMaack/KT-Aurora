@file:Suppress("EnumEntryName", "EnumNaming", "SpellCheckingInspection")
package page

import kotlin.concurrent.Volatile

internal enum class Anagram {
    abc,
    `01`,
    `0123456789`,
    abcdefghijklmnopqrstuvwxyz,
}

internal class IdentifierGenerator(anagram: String) {
    private val availableLetters: String = anagram.ifEmpty { "a" }
    private val firstLetter: String = availableLetters.first().toString()
    private val lastLetter: Char = availableLetters.last()
    private val length: Int = availableLetters.length

    @Volatile
    private var currentValue: String = availableLetters.first().toString()

    operator fun invoke(): String  {
        val result = currentValue
        val lastIndexWithNotLastCharacter = lastIndexWithNotLastCharacter()
        val firstPart = getUnchangedPart(lastIndexWithNotLastCharacter)
        val secondPart = increaseCharacter(lastIndexWithNotLastCharacter)
        val lastPart = firstLetter.repeat(currentValue.length - lastIndexWithNotLastCharacter - 1)
        currentValue = firstPart + secondPart + lastPart
        return result
    }

    private inline fun getUnchangedPart(lastIndexWithNotLastCharacter: Int): String =
        if(lastIndexWithNotLastCharacter == -1) firstLetter
        else currentValue.substring(0, lastIndexWithNotLastCharacter)

    private inline fun increaseCharacter(index: Int): String {
        if(index <= -1)
            return ""
        val currentCharacter = currentValue[index]
        val indexOfCurrentCharacter = availableLetters.indexOf(currentCharacter)
        return availableLetters[(indexOfCurrentCharacter + 1)%length].toString()
    }

    private inline fun lastIndexWithNotLastCharacter(): Int =
        currentValue.indexOfLast { it != lastLetter}

}

public object ClassGenerator {
    private val generator = IdentifierGenerator(Anagram.abcdefghijklmnopqrstuvwxyz.name)
    public operator fun invoke(): String =
        generator()
}

object ScrabbleScore {

    private val scoreMap = mapOf<Char, Int>(
        'A' to 1,
        'E' to 1,
        'I' to 1,
        'O' to 1,
        'U' to 1,
        'L' to 1,
        'N' to 1,
        'R' to 1,
        'S' to 1,
        'T' to 1,
        'D' to 2,
        'G' to 2,
        'B' to 3,
        'C' to 3,
        'M' to 3,
        'P' to 3,
        'F' to 4,
        'H' to 4,
        'V' to 4,
        'W' to 4,
        'Y' to 4,
        'K' to 5,
        'J' to 8,
        'X' to 8,
        'Q' to 10,
        'Z' to 10,
    )

    fun scoreLetter(c: Char): Int {
        val char = c.uppercaseChar()
        return scoreMap[char] ?: 0
    }

    fun scoreWord(word: String): Int {
        return word.toCharArray().sumOf { c -> scoreLetter(c) }
    }
}

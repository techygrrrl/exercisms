class IsbnVerifier {
    // e.g. 3-598-21508-8
    // (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9 * 2 + x10 * 1) mod 11 == 0
    fun isValid(number: String): Boolean {
        // Uppercase to make life easier
        val upperCased = number.uppercase()

        // List of strings, either digits 0-9 or X
        val digitStrings: List<String> = upperCased
            .replace("-".toRegex(), "")
            .split("")
            .filter { it.isNotBlank() }

        // Invalid characters are non-digits that are not X
        val hasInvalidChars = digitStrings.any(::isInvalidStringDigit)

        if (hasInvalidChars) return false

        // ISBN must be 10 digits long
        if (digitStrings.count() != 10) return false

        // X can only be the check digit (last digit) so we check all but last for X
        val hasInvalidDigits = digitStrings
            .subList(0, 8)
            .any { d -> d.matches("\\D".toRegex()) }
        if (hasInvalidDigits) return false

        // Ok it's valid and safe to convert to an integer
        val sum: Int = digitStrings
            .foldIndexed(0) { idx, acc, d ->
                val multiplier = 10 - idx // 0 -> 10, 1 -> 9, 2 -> 8
                val digit: Int = if (d == "X") 10 else d.toInt()
                val value: Int = digit * multiplier

                acc + value
            }

        return sum % 11 == 0
    }
}

/**
 * if non-digit other than X, it's invalid
 */
fun isInvalidStringDigit(d: String): Boolean {
    if (d == "X") return false
    return d.matches("\\D".toRegex())
}
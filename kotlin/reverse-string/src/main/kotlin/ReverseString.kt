fun reverse(input: String): String {
    var count = input.count()
    var output = ""

    while (count > 0) {
        val letter = output[count]
        output += letter
        count--
    }

    return output
}

// actually tho:
//fun reverse(input: String): String = input.reversed()
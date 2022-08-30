fun twofer(name: String): String {
    val printedName = name.ifEmpty { "you" }
    return "One for $printedName, one for me."
}

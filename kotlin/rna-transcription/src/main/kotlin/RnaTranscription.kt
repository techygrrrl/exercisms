fun transcribeToRna(dna: String): String {
    val replacements = mapOf(
        'G' to 'C',
        'C' to 'G',
        'T' to 'A',
        'A' to 'U',
    )
    return dna.map { replacements[it] ?: it }.joinToString("")
}

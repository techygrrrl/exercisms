class KindergartenGarden(private val diagram: String) {

    private val rows = diagram.split("\n")

    private val students = listOf(
        "Alice", "Bob", "Charlie",
        "David", "Eve", "Fred",
        "Ginny", "Harriet", "Ileana",
        "Joseph", "Kincaid", "Larry",
    )

    fun getPlantsOfStudent(student: String): List<String> {
        val studentIndex = students.indexOf(student)
        val firstPlantIndex = studentIndex * 2

        return rows
            .flatMap { row ->
                listOf(
                    getPlantName(row[firstPlantIndex]),
                    getPlantName(row[firstPlantIndex + 1]),
                )
            }
    }

    private fun getPlantName(letter: Char): String =
        mapOf(
            'C' to "clover",
            'G' to "grass",
            'R' to "radishes",
            'V' to "violets"
        )[letter]!!
}

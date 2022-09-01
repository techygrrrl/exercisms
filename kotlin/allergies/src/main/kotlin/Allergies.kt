class Allergies(val score: Int) {
    private val allergies = mutableListOf<Allergen>()

    // 1        - Eggs
    // 10       - Peanuts
    // 100      - Shellfish
    // 1000     - Strawberries
    // 10000    - Tomatoes
    // 100000   - Chocolate
    // 1000000  - Pollen
    // 10000000 - Cats

    // TODO: implement proper constructor to complete the task
    init {
        val base2Score = score.toString(2)
        println("string score: $base2Score")

        val allergenValues = Allergen.values()

        base2Score.reversed().forEachIndexed { idx, char ->
            if (idx > allergenValues.size - 1) {
                return@forEachIndexed
            }

            if (char == '1') {
                val allergen = allergenValues[idx]
                allergies.add(allergen)
            }
        }

        println("Allergies: $allergies")

/*
        allergenValues
//            .map { it.score.toString(2) }
            .forEachIndexed { index, allergen ->
                val base10 = allergen.score
                val base2 = allergen.score.toString(2)
                val lastIndex = (stringScore.length - index)// + 1
//                val allergenIndex = stringScore.length - lastIndex

//                val isAllergen = stringScore[lastIndex]


                // 100 -> substring(lastIndex - 2, lastIndex)
                // lastIndex - 2 == 1 -> then it's an allergen

//                val sublist = stringScore.substring( lastIndex)

//                val base10Allergen = Integer.valueOf(allergen)
//                println("allergen:: base10 = $base10, base2 = $base2, idx = $index - last index $lastIndex")
                println("allergen:: base10 = $base10, base2 = $base2, allergen index: ${stringScore[lastIndex]} idx = $index - last index $lastIndex")
//            val allergenIndex = 1 + index
            }
        */
    }

    fun getList(): List<Allergen> {
        return allergies
    }

    fun isAllergicTo(allergen: Allergen): Boolean {
        return allergies.contains(allergen)
    }
}

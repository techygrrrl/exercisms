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

    init {
        val base2Score = score.toString(2)

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
    }

    fun getList(): List<Allergen> {
        return allergies
    }

    fun isAllergicTo(allergen: Allergen): Boolean {
        return allergies.contains(allergen)
    }
}
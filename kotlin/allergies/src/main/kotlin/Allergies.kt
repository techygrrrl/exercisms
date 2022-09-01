class Allergies(val score: Int) {
    // 1        - Eggs
    // 10       - Peanuts
    // 100      - Shellfish
    // 1000     - Strawberries
    // 10000    - Tomatoes
    // 100000   - Chocolate
    // 1000000  - Pollen
    // 10000000 - Cats

    private val allergies: List<Allergen> =
        Allergen.values().filter { allergen ->
            (score and allergen.score) == allergen.score
        }

    fun getList(): List<Allergen> = allergies

    fun isAllergicTo(allergen: Allergen): Boolean =
        (score and allergen.score) == allergen.score
}
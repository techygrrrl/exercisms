val existingRobots = mutableSetOf<String>()

class Robot {
    private val availableLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

    private var _name: String
    init {
        _name = generateRobotName()
    }

    val name: String get() = _name

    fun reset() {
        _name = generateRobotName()
    }

    private fun generateRobotName(): String {
        var randomName = ""

        do {
            randomName = getRandomName()
        } while (existingRobots.contains(randomName))

        existingRobots.add(randomName)

        return randomName
    }

    private fun getRandomName(): String {
        var output = ""

        for (i in 1..2) {
            val letter = availableLetters.random()
            output += letter
        }

        for (i in 1..3) {
            val number = (0..9).random()
            output += "$number"
        }

        return output
    }
}

import org.junit.Test
import kotlin.test.assertNotNull

class ExercismTest {
    @Test
    fun canPerformAnExercism() {
        val exercisms = listOf<Exercism>(
            Exercism("kotlin"),
            Exercism("easy"),
            Exercism("medium"),
            Exercism("algorithms"),
        )

        exercisms.forEach { exercism ->
            val result = exercism.perform()

            println(result)

            assertNotNull(result)
        }
    }
}
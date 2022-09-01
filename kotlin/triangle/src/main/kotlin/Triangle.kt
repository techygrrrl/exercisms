class Triangle<out T : Number>(val a: T, val b: T, val c: T) {
    // An equilateral triangle has all three sides the same length.
    val isEquilateral: Boolean

    // at least two sides the same length
    val isIsosceles: Boolean

    // A scalene triangle has all sides of different lengths
    val isScalene: Boolean

    val isDegenerate: Boolean

    init {
        // Zeros are invalid triangles
        if (
            a == 0 ||
            b == 0 ||
            c == 0
        ) throw IllegalArgumentException()

        val aFloat = a.toFloat()
        val bFloat = b.toFloat()
        val cFloat = c.toFloat()

        // Validate triangle math
        // QuLogic: basically negating all of an AND/OR is equivalent to negating all the inputs and switching AND/OR
        // QuLogic: like NOT(a AND b) -> (NOT a OR NOT b) .. and vice-versa
        // Trick XOR Treat: https://www.reddit.com/r/funny/comments/jhzdp5/trick_xor_treat/
        // DeMorgan: https://www.electronics-tutorials.ws/boolean/demorgan.html
        val abNonMatch = (aFloat + bFloat) < cFloat
        val acNonMatch = (aFloat + cFloat) < bFloat
        val bcNonMatch = (bFloat + cFloat) < aFloat

        if (abNonMatch || acNonMatch || bcNonMatch) {
            throw IllegalArgumentException()
        }

        isIsosceles = bFloat == cFloat || aFloat == bFloat || aFloat == cFloat

        isEquilateral = aFloat == bFloat && bFloat == cFloat

        isScalene = !isIsosceles

        isDegenerate = (bFloat + aFloat) == cFloat ||
                (aFloat + cFloat) == bFloat ||
                (bFloat + cFloat) == aFloat
    }

}
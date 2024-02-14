object Hamming {

    fun compute(leftStrand: String, rightStrand: String): Int {
        if ("" == leftStrand && "" == rightStrand) return 0

        if (leftStrand.length != rightStrand.length)
            throw IllegalArgumentException("left and right strands must be of equal length")

        return leftStrand
            .foldIndexed(0) { index, acc, leftChar ->
                val rightChar = rightStrand[index]
                var acc = acc

                if (leftChar != rightChar) {
                    acc += 1
                }

                acc
            }
    }
}

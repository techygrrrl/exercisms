class ChainNotFoundException(msg: String) : RuntimeException(msg)

data class Domino(val left: Int, val right: Int) {
    override fun toString(): String = "[$left|$right]"
}

// used to find the start and end
// odd is the start of the domino
// even is the end of the domino

object Dominoes {

//    private fun findLowestDomino(inputDominoes: List<Domino>): Domino {
//        var lowerBound = 1
//
//        var domino: Domino? = null
//
//        while (domino == null) {
//            domino = inputDominoes.find { it.left == lowerBound }
//            if (domino == null) {
//                lowerBound++
//            }
////            try {
////
////            } catch (e: NoSuchElementException) {
////                lowerBound++
////                throw ChainNotFoundException("We should never get here")
////            }
//        }
//
//        return domino
//    }

    fun formChain(inputDominoes: List<Domino>): List<Domino> {
        val availableDominoes = inputDominoes.toMutableList()
        val startingDomino = availableDominoes.removeFirst()

        while (availableDominoes.isNotEmpty()) {
//            val nextDomino =
        }

        println("input (size = ${inputDominoes.size}) : $inputDominoes")

        // Starting domino
        // look for another one with left
        // look for another one with right

//        val startingDomino = inputDominoes.find { it.left == 1 }


        // Order the dominoes

        inputDominoes.forEachIndexed { index, startingDomino ->
            inputDominoes.forEach { otherDomino ->
                // compare starting to other
            }
        }

        // start with any domino ????

        // can we efficiently find what dominoes should be placed next to it?

        // 1. find upper and lower bounds of the dominoes
        // 2. ensure it works with the lower bounds at the end
        // 3. ensure it works with the upper bounds at the end

        // circle
        // graph

        return listOf()
    }

//    private fun compareDominoes(a: Domino, b: Domino): Int {
//        if (a.right == b.left) return -1
//        if (b.right == a.left) return 1
//        return 0
//    }
//    fun formChain(inputDominoes: List<Domino>): List<Domino> {
//        println("input: $inputDominoes")
//
//        val sorted = inputDominoes.sortedWith(::compareDominoes)
//        val reverseSorted = inputDominoes.reversed().sortedWith(::compareDominoes)
//        println("sorted: $sorted reverseSorted = $reverseSorted")
//
//        val first = sorted.first()
//        val last = sorted.last()
//
//        if (first.left != last.right) {
//            throw ChainNotFoundException(inputDominoes.toString())
//        }
//
//
//        return sorted
//    }
}

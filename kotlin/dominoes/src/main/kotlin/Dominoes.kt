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

    private fun List<Domino>.findADominoWithSide(n: Int): Domino? =
        find { domino ->
            domino.right == n || domino.left == n
        }

//    private fun buildChain(list: List<Domino>): List<Domino> {
//        if (list.size <= 1) return list
//
//        val first = list.first()
//        val last = list.last()
//
//        if (first.right == last.left) {
//            return list
//        }
//
//        val oldLastLeft = last.left
//        val oldLastRight = last.right
//
//        return listOf(
//            first,
//            Domino(left = oldLastRight, right = oldLastLeft)
//        )
//    }

    private fun List<Domino>.findMatches(n: Int): List<Domino> =
        filter { domino ->
            domino.left == n || domino.right == n
        }

//        filter {
//            it.left == domino.left ||
//            it.left == domino.right ||
//            it.right == domino.left ||
//            it.right == domino.right
//        }
//

    fun formChain(inputDominoes: List<Domino>): List<Domino> {
        // This is helpful (7901ben: https://cdn.discordapp.com/attachments/1016635589321314337/1016635846478278687/IMG_20220906_143715.jpg)
        /*
            - split left/right into their own arrays
            - check if any element in the left matches an element in the right list
                - if not found, check the right side
            - push this to a mega array
            - add its corresponding side to the mega array
            - remove both the left and right from their leftSide/rightSide arrays
            - keep going until the leftSide/rightSide arrays are empty
            - the mega array can be converted into dominos
            - megaArray.forEachIndexed { idx, n -> idx % 2 == 1 then itsLeft else itsRight }
            - megaArray.chunked(2).map { (a, b) -> Domino(left=a, right=b) }
         */

        if (inputDominoes.isEmpty()) return listOf()

        if (inputDominoes.size == 1) {
            val onlyDomino = inputDominoes.first()
            if (onlyDomino.left != onlyDomino.right) {
                throw ChainNotFoundException(inputDominoes.toString())
            }
        }

        // mega array
        val flattenedDominoesOutput = mutableListOf<Int>()

        val leftSides = inputDominoes.map { it.left }.toMutableList()
        val rightSides = inputDominoes.map { it.right }.toMutableList()

        // Place the first domino
        val firstLeft = leftSides[0]
        val firstRight = rightSides[0]

        /*
            for example u have dominos [2,1] [2,3] u place 2,1 first
            then in the second domino
            nothing matches so u need to flip the 1st domino

            [1,2] -> [2,3]
         */
//        if (leftSides.indexOf(firstLeft) == -1) {
//            // Should flip
//            flattenedDominoesOutput.add(firstRight)
//            flattenedDominoesOutput.add(firstLeft)
//        } else {
//            flattenedDominoesOutput.add(firstLeft)
//            flattenedDominoesOutput.add(firstRight)
//        }

        // TODO: Handle edge case we need to flip the very first domino

        flattenedDominoesOutput.add(firstLeft)
        flattenedDominoesOutput.add(firstRight)

        leftSides.removeAt(0)
        rightSides.removeAt(0)


        // Place the others
        var numberToMatch = firstRight

        try {
            while (leftSides.size > 0) {
                var isFlipped = false

                // First we check the first one of the left side
                var currentIndex = leftSides.indexOf(numberToMatch) // 4
//            var currentHalf = leftSides[currentIndex]


                // Find a match on the right side
//            var matchingIndex = rightSides.indexOf(currentHalf)

                // If we have no match, flip the domino
                if (currentIndex == -1) {
//            if (matchingIndex == -1) {
                    // This is the first domino we placed. We need to flip
//                currentHalf = rightSides[currentIndex]
                    currentIndex = rightSides.indexOf(numberToMatch)

                    isFlipped = true

                    // Remove from the half arrays
//                leftSides.removeAt(matchingIndex)
//                rightSides.removeAt(currentIndex)
                } else {
                    // Remove from the half arrays
//                leftSides.removeAt(currentIndex)
//                rightSides.removeAt(currentIndex)
                }


                val currentHalf = if (isFlipped) {
                    rightSides[currentIndex]
                } else leftSides[currentIndex]

                val matchingHalf = if (isFlipped) {
                    leftSides[currentIndex]
                } else rightSides[currentIndex]

                leftSides.removeAt(currentIndex)
                rightSides.removeAt(currentIndex)

                // Add them to the mega array
                flattenedDominoesOutput.add(currentHalf)
                flattenedDominoesOutput.add(matchingHalf)

                numberToMatch = matchingHalf

                println("Flattened = $flattenedDominoesOutput")
            }

        } catch (e: IndexOutOfBoundsException) {
            throw ChainNotFoundException(inputDominoes.toString())
        }

        return flattenedDominoesOutput
            .chunked(2)
            .map { list ->
                val (left, right) = list
                Domino(left = left, right = right)
            }
    }


//    fun formChain(inputDominoes: List<Domino>): List<Domino> {
//        if (inputDominoes.size <= 1) return inputDominoes
//
////        val availableDominos = inputDominoes.filterIndexed { index, domino ->
////            index > 0
////        }
//
//        val first = inputDominoes.first()
////        availableDominos.remove(first)
//
//        val matches = inputDominoes.findMatches(first.right)
//        matches.forEachIndexed { index, domino ->
//            val subList = inputDominoes.filterIndexed { idx2, domino2 ->
//
//            }
//            // first
//            // domino
//            // remaining list
////            inputDominoes.subList(index + 1, inputDominoes.size - 1)
//
//        }
////        val next = inputDominoes[1] // this could explode
//
//        val fakeDomino = Domino(-1, -1)
//
////        return inputDominoes.map { domino ->
////
////        }
//
////        inputDominoes.forEach { domino ->
////            val matches = listOf(domino, fakeDomino).findMatches(domino.right)
////            println("Matches for domino $domino = $matches")
////
//////            return matches
////        }
//
//
//
////        var startingIndex = 0
////        var endingIndex = 2
////
////        val subList = inputDominoes.subList(startingIndex, endingIndex)
////        while (endingIndex < inputDominoes.size) {
////
////        }
//
//
//        return listOf()
//    }


//    fun formChain(inputDominoes: List<Domino>): List<Domino> {
//        val output = mutableListOf<Domino>()
//
//        val availableDominoes = inputDominoes.toMutableList()
//
//        var currentDomino = availableDominoes.removeFirst()
//        var otherDominoSide = currentDomino.right
//
//        output.add(currentDomino)
//
//        println("starting domino: $currentDomino - Remaining: $availableDominoes")
//
//
//        while (availableDominoes.isNotEmpty()) {
//            println("Searching for side $otherDominoSide")
//
//            // TODO: Fix. this is bad.
//            var anotherDomino = availableDominoes.findADominoWithSide(otherDominoSide)
//            while (anotherDomino == null) {
//                anotherDomino = availableDominoes.findADominoWithSide(??)
//            }
//
//            if (currentDomino.right == anotherDomino.left) {
//                // We good, no flipping required
//                otherDominoSide = anotherDomino.right
//                currentDomino = anotherDomino
//                output.add(anotherDomino)
//            } else {
//                // Flipping
//                val oldLeft = anotherDomino.left
//                val oldRight = anotherDomino.right
//
//                otherDominoSide = anotherDomino.left
//
//                val flippedDomino = Domino(left = oldRight, right = oldLeft)
//                currentDomino = flippedDomino
//
//                output.add(flippedDomino)
//            }
//
//
//            availableDominoes.remove(anotherDomino)
//            println("Found a domino: $anotherDomino - Remaining: $availableDominoes ")
//
////            otherDominoSide = if (anotherDomino.left == otherDominoSide) {
////                anotherDomino.right
////            } else {
////                anotherDomino.left
////            }
//
//
//
//            println("OUTPUT = $output")
//        }
//
//        println("input (size = ${inputDominoes.size}) : $inputDominoes")
//
//        // Starting domino
//        // look for another one with left
//        // look for another one with right
//
////        val startingDomino = inputDominoes.find { it.left == 1 }
//
//
//        // Order the dominoes
//
//        inputDominoes.forEachIndexed { index, startingDomino ->
//            inputDominoes.forEach { otherDomino ->
//                // compare starting to other
//            }
//        }
//
//        // start with any domino ????
//
//        // can we efficiently find what dominoes should be placed next to it?
//
//        // 1. find upper and lower bounds of the dominoes
//        // 2. ensure it works with the lower bounds at the end
//        // 3. ensure it works with the upper bounds at the end
//
//        // circle
//        // graph
//
//        return output
//    }

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

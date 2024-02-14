object BinarySearch {
    fun search(list: List<Int>, item: Int): Int {
        var leftCursor = 0
        var rightCursor = list.size - 1

        while (leftCursor <= rightCursor) {
            val middleCursor = (leftCursor + rightCursor) / 2
            val middleValue = list[middleCursor]

            // Middle item is the same as the target item. Item found!
            if (middleValue == item) {
                return middleCursor
            }

            if (middleValue < item) {
                // Middle item is smaller than the target item. Move cursor to the right.
                leftCursor = middleCursor + 1
            } else {
                // Middle item is larger than the target item. Move cursor to the left.
                rightCursor = middleCursor - 1
            }
        }

        throw NoSuchElementException()
    }
}

class Deque<T> {

    private class Node<T>(
        val value: T,
        var previous: Node<T>? = null,
        var next: Node<T>? = null,
    ) {
        override fun toString(): String {
            return "Node(value = $value, previous=${previous?.value}, next=${next?.value})"
        }
    }

    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    private var length: Int = 0


    fun push(value: T) {
        val node = Node(value)

        // if we have NO tail, this new element is the tail
        if (tail == null) {
            tail = node
            head = node
        } else {
            // We already have a tail
            tail!!.next = node
            node.previous = tail

            tail = node
        }

        length++
    }

    fun pop(): T? {
        if (tail == null) return null

        val tailValue = tail!!.value

        tail = tail!!.previous

        length--
        if (length == 1) {
            head = tail
        }

        return tailValue
    }

    fun unshift(value: T) {
        val node = Node(value)

        if (head == null) {
            head = node
            tail = node
        } else {
            // We already have a head
            node.next = head
            head!!.previous = node
            head = node
        }

        length++
    }

    fun shift(): T? {
        if (head == null) return null

        val headValue = head!!.value

        head = head!!.next

        length--
        if (length == 1) {
            tail = head
        }

        return headValue
    }
}

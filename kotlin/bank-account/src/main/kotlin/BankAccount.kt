import java.util.concurrent.atomic.AtomicInteger

class BankAccount {
    val balance: Int get() {
        if (state == State.CLOSED) throw IllegalStateException()
        return _balance.get()
    }

    private var _balance = AtomicInteger(0)

    private var state: State = State.OPEN

    private enum class State {
        OPEN,
        CLOSED
    }

    fun adjustBalance(amount: Long){
        if (state == State.CLOSED) throw IllegalStateException()

        _balance.getAndAdd(amount.toInt())
    }

    fun close() {
        state = State.CLOSED
    }
}


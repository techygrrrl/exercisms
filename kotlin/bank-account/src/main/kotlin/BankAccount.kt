import java.util.concurrent.locks.ReentrantLock

class BankAccount {
    private val lock = ReentrantLock(true)

    val balance: Int get() {
        if (state == State.CLOSED) throw IllegalStateException()
        return _balance
    }

    private var _balance: Int = 0

    private var state: State = State.OPEN

    private enum class State {
        OPEN,
        CLOSED
    }

    fun adjustBalance(amount: Long){
        if (state == State.CLOSED) throw IllegalStateException()

        lock.lock()
        val previousBalance = balance
        val newBalance: Int = previousBalance + amount.toInt()
        _balance = newBalance
        lock.unlock()
    }

    fun close() {
        state = State.CLOSED
    }
}


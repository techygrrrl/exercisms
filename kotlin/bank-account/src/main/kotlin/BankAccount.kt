import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicReference
import java.util.concurrent.locks.ReentrantLock
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class BankAccount {
    private val lock = ReentrantLock(true)

    val balance: Int get() {
        if (state == State.CLOSED) throw IllegalStateException()
        return _balance
    }

    private var _balance: Int = 0
//    private var _balance: Int by atomic(0)
//    private var _balance = AtomicInteger(0)


    private var state: State = State.OPEN

    private enum class State {
        OPEN,
        CLOSED
    }

    /**
     * Add or remove money depending on the positive/negative'ness
     */
    fun adjustBalance(amount: Long){
        if (state == State.CLOSED) throw IllegalStateException()

        lock.lock()
        val previousBalance = balance
        val newBalance: Int = previousBalance + amount.toInt()
        _balance = newBalance
        lock.unlock()

        // by atomic delegate
//        val previousBalance = balance
//        val newBalance: Int = previousBalance + amount.toInt()
//        _balance = newBalance

        // Re-entrant lock


//        val newBalance = _balance.addAndGet(amount.toInt())
//        _balance.set(newBalance.toInt())
//        balance += amount.toInt()
    }

    fun close() {
        state = State.CLOSED
    }
}


private fun <T>atomic(tIn: T): ReadWriteProperty<Any?, T> {
    return object : ReadWriteProperty<Any?, T> {
        val t = AtomicReference<T>(tIn)
        override fun getValue(thisRef: Any?, property: KProperty<*>): T {
            return t.get()
        }

        override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
            t.set(value)
        }
    }
}


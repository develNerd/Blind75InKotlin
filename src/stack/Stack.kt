package stack

interface Stack<T : Any> {
    fun push(value: T)
    fun pop(): T?
}

class StackImpl<T : Any> : Stack<T> {

    val storage = mutableListOf<T>()

    override fun push(value: T) {
        storage.add(value)
    }

    override fun pop(): T? {
        if (storage.isEmpty()) {
            return null
        }
        return storage.removeAt(storage.size - 1)
    }

}

fun main() {
    val myStack = StackImpl<Int>()
    myStack.push(2)
}
package trees


/**
 *
 *
 *
 *
• The value of a left child must be less than the value of its parent.
• Consequently, the value of a right child must be greater than or equal to the value
of its parent

O(logn)
 * */
class BinarySearchTree<T: Comparable<T>>() {
    var root: BinaryNode<T>? = null
    var leftChild: BinaryNode<T>? = null
    var rightChild: BinaryNode<T>? = null
    fun insert(value: T) {
        root = insert(root, value)
    }
    private fun insert(
        node: BinaryNode<T>?,
        value: T
    ): BinaryNode<T> {
        // 1
        node ?: return BinaryNode(value)
        // 2
        if (value < node.value) {
            node.leftChild = insert(node.leftChild, value)
        } else {
            node.rightChild = insert(node.rightChild, value)
        }
        // 3
        return node
    }


    fun contains(value: T): Boolean {
        root ?: return false
        var found = false
        root?.traverseInOrder {
            if (value == it) {
                found = true
            }
        }
        return found
    }

    fun containsOpt(value: T): Boolean {
        // 1
        var current = root
        // 2
        while (current != null) {
            // 3
            if (current.value == value) {
                return true
            }
            // 4
            current = if (value < current.value) {
                current.leftChild
            } else {
                current.rightChild
            }
        }
        return false
    }

}


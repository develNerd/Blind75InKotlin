package trees

import java.util.*


fun main() {
    val breakFast = TreeNode("Tea")
    breakFast.addChild(TreeNode("coffee").apply {
        addChild(TreeNode("Coffee Latte"))
        addChild(TreeNode("Cafe Mocha"))
    })
    breakFast.addChild(TreeNode("Iced Tea").apply {
        addChild(TreeNode("Green Tea"))
        addChild(TreeNode("Milo"))
    })


}


class TreeNode<T>(val value: T) {
    val children: MutableList<TreeNode<T>> = mutableListOf()

    fun addChild(child: TreeNode<T>) = children.add(child)


    fun depthFirstSearch(visit: (TreeNode<T>) -> Unit) {
        visit(this)
        children.forEach {
            it.depthFirstSearch(visit)
        }
    }

    fun forEachLevelOrder(visit:(TreeNode<T>) -> Unit) {
        visit(this)
        val queue:Queue<TreeNode<T>> = LinkedList<TreeNode<T>>()
        children.forEach { queue.add(it) }
        var node = queue.remove()
        while (node != null) {
            visit(node)
            node.children.forEach { queue.add(it) }
            node = queue.remove()
        }
    }

}
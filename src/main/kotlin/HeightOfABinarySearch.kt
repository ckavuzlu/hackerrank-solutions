import kotlin.math.max

data class Node(
    var data: Int? = null,
    var left: Node? = null,
    var right: Node? = null
)

/**
 * Java solution had default Node class and insert function but Kotlin didn't.
 * I implemented Node data class and insert extension function
 */

fun main(args: Array<String>) {
    var binaryTree = Node()

    val inputLength = readLine()!!.trim().toInt()
    val a = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    a.forEach {
        binaryTree.insert(it)
    }

    println(getHeight(binaryTree).toString())
}

fun getHeight(root: Node?): Int {
    var leftHeight = 0
    var rightHeight = 0
    if (root?.left != null) leftHeight = getHeight(root.left) + 1
    if (root?.right != null) rightHeight = getHeight(root.right) + 1

    return max(leftHeight, rightHeight)
}

fun Node.insert(newData: Int) {
    if (data == null) {
        data = newData
    } else {
        if (newData <= data!!) {
            if (left == null) left = Node(data = newData) else left!!.insert(newData)
        } else {
            if (right == null) right = Node(data = newData) else right!!.insert(newData)
        }
    }
}

package lib.base

open class TransientTag: TagWithText("") {
    override fun traverse(visitor: Visitor) {
        children.forEach { it.traverse(visitor) }
    }
}

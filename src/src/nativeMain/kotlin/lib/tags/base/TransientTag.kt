package lib.tags.base

open class TransientTag: TagContainer("") {
    override fun traverse(visitor: Visitor) {
        children.forEach { it.traverse(visitor) }
    }
}

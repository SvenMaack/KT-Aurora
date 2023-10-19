package lib.tags.base

interface Element {
    fun traverse(visitor: Visitor)
}

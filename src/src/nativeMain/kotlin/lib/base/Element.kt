package lib.base

interface Element {
    fun traverse(visitor: Visitor<*>)
}

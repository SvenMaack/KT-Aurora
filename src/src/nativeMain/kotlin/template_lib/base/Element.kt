package template_lib.base

interface Element {
    fun traverse(visitor: Visitor<*>)
}

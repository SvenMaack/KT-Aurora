package template_lib.base

@DslMarker
annotation class HtmlTagMarker

@HtmlTagMarker
open class Tag(val name: String) : Element {
    override fun traverse(visitor: Visitor<*>) {
        visitor.visitTag(this)
    }
}

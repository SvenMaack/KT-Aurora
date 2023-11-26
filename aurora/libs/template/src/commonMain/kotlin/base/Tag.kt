package template_lib.base

@DslMarker
public annotation class HtmlTagMarker

@HtmlTagMarker
public open class Tag(public val name: String) : Element {
    override fun traverse(visitor: Visitor<*>) {
        visitor.visitTag(this)
    }
}

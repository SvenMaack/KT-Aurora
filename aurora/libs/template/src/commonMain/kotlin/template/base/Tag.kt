package template.base

@DslMarker
public annotation class HtmlTagMarker

@HtmlTagMarker
public open class Tag(public val name: String) : Element {
    override fun traverse(htmlVisitor: HtmlVisitor<*>) {
        htmlVisitor.visitTag(this)
    }
}

package lib.base

@DslMarker
annotation class HtmlTagMarker

open class Tag(name: String) : Element {
    val tagName: String

    init {
        this.tagName = createTag(name)
    }

    override fun traverse(visitor: Visitor) {
        visitor.visitTag(this)
    }

    protected open fun createTag(name: String): String = name
}

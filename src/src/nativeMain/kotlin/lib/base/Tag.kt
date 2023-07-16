package lib.base

@DslMarker
annotation class HtmlTagMarker

@HtmlTagMarker
open class Tag(name: String) : Element {
    val tagName: String

    init {
        this.tagName = createTag(name)
    }

    override fun traverse(visitor: Visitor) {
        visitor.visitTag(this)
    }

    private inline fun createTag(name: String): String = name
        .trim()
        .lowercase()
        .filter {
            it.isLetterOrDigit()
        }
        .ifEmpty {
            "empty"
        }
}

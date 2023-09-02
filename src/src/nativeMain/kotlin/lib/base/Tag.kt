package lib.base

@DslMarker
annotation class HtmlTagMarker

@HtmlTagMarker
open class Tag(name: String) : Element {
    val tagName: String
    var attributes: Array<out Attribute> = arrayOf()

    init {
        this.tagName = createTag(name)
    }

    override fun traverse(visitor: Visitor) {
        visitor.visitTag(this)
    }

    fun setAttributes(attributes: Array<out Attribute>): Tag {
        this.attributes = attributes
        return this
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

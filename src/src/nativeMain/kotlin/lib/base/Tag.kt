package lib.base

@DslMarker
annotation class HtmlTagMarker

@HtmlTagMarker
open class Tag(name: String) : Element {
    val tagName: String
    var attributes: Map<String, List<String>> = mapOf()

    init {
        this.tagName = createTag(name)
    }

    override fun traverse(visitor: Visitor) {
        visitor.visitTag(this)
    }

    fun setAttributes(vararg attributes: Attribute): Tag {
        this.attributes = attributes.groupBy({ it.name }, { it.value })
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

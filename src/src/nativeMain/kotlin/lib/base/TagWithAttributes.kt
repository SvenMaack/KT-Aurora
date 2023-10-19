package lib.base

import lib.tags.HtmlTagMarker
import lib.tags.Tag

@HtmlTagMarker
open class TagWithAttributes(name: String) : Tag(name) {
    var attributes: Map<String, List<String>> = mapOf()

    override fun traverse(visitor: Visitor) {
        visitor.visitTagWithAttributes(this)
    }

    fun setAttributes(vararg attributes: Attribute): TagWithAttributes {
        this.attributes = attributes.groupBy({ it.name }, { it.value })
        return this
    }

    override fun createTag(name: String): String =  name
        .trim()
        .lowercase()
        .filter {
            it.isLetterOrDigit()
        }
        .ifEmpty {
            "empty"
        }
}

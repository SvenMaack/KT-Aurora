package lib.visitors

import lib.base.*
import lib.tags.Tag

class ProductionVisitor: Visitor {
    private val _html = StringBuilder()
    override val html: String
        get() = _html.toString()

    override fun visitTag(tag: Tag) {
        _html.append("<${tag.tagName}>")
    }

    override fun visitComment(comment: Comment) {
        //silence is golden
    }

    override fun visitTagWithAttributes(tag: TagWithAttributes) {
        _html.append("<${tag.tagName}${renderAttributes(tag.attributes)}>")
    }

    override fun visitTagContainerBegin(tagContainer: TagContainer) {
        _html.append("<${tagContainer.tagName}${renderAttributes(tagContainer.attributes)}>")
    }

    override fun visitTagContainerEnd(tagContainer: TagContainer) {
        _html.append("</${tagContainer.tagName}>")
    }

    override fun visitTextElement(element: TextElement) {
        _html.append(element.text)
    }

    private fun renderAttributes(attributes: Map<String, List<String>>): String =
        attributes.entries.joinToString("") {
            renderOneAttribute(it)
        }

    private inline fun renderOneAttribute(entry: Map.Entry<String, List<String>>): String {
        val values = entry.value.filter { it.isNotEmpty() }
        return if(values.isEmpty())
            " ${entry.key}"
        else
            " ${entry.key}=\"${this.renderValuesOfOneAttribute(values)}\""
    }

    private inline fun renderValuesOfOneAttribute(values: List<String>): String =
        values.joinToString(" ")
}

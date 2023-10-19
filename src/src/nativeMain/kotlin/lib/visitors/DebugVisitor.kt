package lib.visitors

import lib.base.*
import lib.tags.Tag

class DebugVisitor: Visitor {
    companion object {
        const val LINE_BREAK = "\n"
        const val INDENTATION = "\t"
    }

    private val _html = StringBuilder()
    override val html: String
        get() = _html.toString()
    private var currentIndentation = ""

    override fun visitTag(tag: Tag) {
        _html.append("$currentIndentation<${tag.tagName}>$LINE_BREAK")
    }

    override fun visitComment(comment: Comment) {
        visitTag(comment)
    }

    override fun visitTagWithAttributes(tag: TagWithAttributes) {
        _html.append("$currentIndentation<${tag.tagName}${renderAttributes(tag.attributes)}>$LINE_BREAK")
    }

    override fun visitTagContainerBegin(tagContainer: TagContainer) {
        _html.append("$currentIndentation<${tagContainer.tagName}${renderAttributes(tagContainer.attributes)}>$LINE_BREAK")
        currentIndentation += INDENTATION
    }

    override fun visitTagContainerEnd(tagContainer: TagContainer) {
        currentIndentation = currentIndentation.dropLast(1)
        _html.append("$currentIndentation</${tagContainer.tagName}>$LINE_BREAK")
    }

    override fun visitTextElement(element: TextElement) {
        _html.append("$currentIndentation${element.text}$LINE_BREAK")
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

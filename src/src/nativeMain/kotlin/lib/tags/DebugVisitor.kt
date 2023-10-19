package lib.tags

import lib.tags.base.*

class DebugVisitor: Visitor {
    companion object {
        const val linebreak = "\n"
        const val indentation = "\t"
    }

    private val _html = StringBuilder()
    val html: String
        get() = _html.toString()
    private var currentIndentation = ""

    override fun visitTag(tag: Tag) {
        _html.append("$currentIndentation<${tag.tagName}>$linebreak")
    }

    override fun visitComment(comment: Comment) {
        visitTag(comment)
    }

    override fun visitTagWithAttributes(tag: TagWithAttributes) {
        _html.append("$currentIndentation<${tag.tagName}${renderAttributes(tag.attributes)}>$linebreak")
    }

    override fun visitTagContainerBegin(tagContainer: TagContainer) {
        _html.append("$currentIndentation<${tagContainer.tagName}${renderAttributes(tagContainer.attributes)}>$linebreak")
        currentIndentation += indentation
    }

    override fun visitTagContainerEnd(tagContainer: TagContainer) {
        currentIndentation = currentIndentation.dropLast(1)
        _html.append("$currentIndentation</${tagContainer.tagName}>$linebreak")
    }

    override fun visitTextElement(element: TextElement) {
        _html.append("$currentIndentation${element.text}$linebreak")
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

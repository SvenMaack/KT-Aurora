package template_lib.visitors

import template_lib.base.*
import template_lib.base.Tag

public class DebugVisitor: Visitor<String> {
    internal companion object {
        const val LINE_BREAK = "\n"
        const val INDENTATION = "\t"
    }

    private val _html = StringBuilder()
    override val result: String
        get() = _html.toString()
    private var currentIndentation = ""

    override fun visitTag(tag: Tag) {
        _html.append("$currentIndentation<${tag.name}>$LINE_BREAK")
    }

    override fun visitComment(comment: Comment) {
        visitTag(comment)
    }

    override fun visitTagWithAttributes(tag: TagWithAttributes) {
        _html.append("$currentIndentation<${tag.name}${renderAttributes(tag.attributes)}>$LINE_BREAK")
    }

    override fun visitTagContainerBegin(tagContainer: TagContainer) {
        _html.append("$currentIndentation<${tagContainer.name}${renderAttributes(tagContainer.attributes)}>$LINE_BREAK")
        currentIndentation += INDENTATION
    }

    override fun visitTagContainerEnd(tagContainer: TagContainer) {
        currentIndentation = currentIndentation.dropLast(1)
        _html.append("$currentIndentation</${tagContainer.name}>$LINE_BREAK")
    }

    override fun visitTagWithText(element: TagWithText) {
        //silence is golden
    }

    override fun visitTextElement(element: TextElement) {
        _html.append("$currentIndentation${element.text}$LINE_BREAK")
    }

    private fun renderAttributes(attributes: Map<String, List<String?>>): String =
        attributes.entries.joinToString("") {
            renderOneAttribute(it)
        }

    private inline fun renderOneAttribute(entry: Map.Entry<String, List<String?>>): String {
        val values = entry.value.filter { it != null && it.isNotEmpty() }
        return if(values.isEmpty())
            " ${entry.key}"
        else
            " ${entry.key}=\"${this.renderValuesOfOneAttribute(values)}\""
    }

    private inline fun renderValuesOfOneAttribute(values: List<String?>): String =
        values.joinToString(" ")
}

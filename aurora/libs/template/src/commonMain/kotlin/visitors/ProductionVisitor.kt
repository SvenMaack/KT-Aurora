package template_lib.visitors

import template_lib.base.*

public class ProductionVisitor: Visitor<String> {
    private val _html = StringBuilder()
    override val result: String
        get() = _html.toString()

    override fun visitTag(tag: Tag) {
        _html.append("<${tag.name}>")
    }

    override fun visitComment(comment: Comment) {
        //silence is golden
    }

    override fun visitTagWithAttributes(tag: TagWithAttributes) {
        _html.append("<${tag.name}${renderAttributes(tag.attributes)}>")
    }

    override fun visitTagContainerBegin(tagContainer: TagContainer) {
        _html.append("<${tagContainer.name}${renderAttributes(tagContainer.attributes)}>")
    }

    override fun visitTagContainerEnd(tagContainer: TagContainer) {
        _html.append("</${tagContainer.name}>")
    }

    override fun visitTextElement(element: TextElement) {
        _html.append(element.text)
    }

    private fun renderAttributes(attributes: Map<String, List<String?>>): String =
        attributes.entries.joinToString("") {
            renderOneAttribute(it)
        }

    override fun visitTagWithText(element: TagWithText) {
        //silence is golden
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

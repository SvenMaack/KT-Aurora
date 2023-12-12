package template.visitors

import template.base.HtmlVisitor
import template.base.Comment
import template.base.HtmlVisitorStrategy
import template.base.TagContainer
import template.base.TextElement
import template.base.TagWithAttributes
import template.base.Tag

public class DebugHtmlVisitor: HtmlVisitor<String> {
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

    override fun visitTextElement(element: TextElement) {
        _html.append("$currentIndentation${element.text}$LINE_BREAK")
    }

    @PublishedApi
    internal inline fun renderAttributes(attributes: Map<String, List<String?>>): String {
        val renderedAttributes = AttributeRenderer.renderAttributes(attributes)
        return if(renderedAttributes.isEmpty()) "" else " $renderedAttributes"
    }

    internal companion object {
        const val LINE_BREAK = "\n"
        const val INDENTATION = "\t"
    }
}

public val debugHtmlVisitorStrategy: HtmlVisitorStrategy<String> = HtmlVisitorStrategy{ DebugHtmlVisitor() }

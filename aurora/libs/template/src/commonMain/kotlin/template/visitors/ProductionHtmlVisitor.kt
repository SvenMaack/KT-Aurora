package template.visitors

import template.base.HtmlVisitor
import template.base.Comment
import template.base.TagContainer
import template.base.TextElement
import template.base.TagWithAttributes
import template.base.Tag

public class ProductionHtmlVisitor: HtmlVisitor<String> {
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

    @PublishedApi
    internal inline fun renderAttributes(attributes: Map<String, List<String?>>): String {
        val renderedAttributes = AttributeRenderer.renderAttributes(attributes)
        return if(renderedAttributes.isEmpty()) "" else " $renderedAttributes"
    }
}

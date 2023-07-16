package lib

import lib.base.Tag
import lib.base.TagContainer
import lib.base.TextElement
import lib.base.Visitor

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
        _html.append("$currentIndentation</${tag.tagName}>$linebreak")
    }

    override fun visitTagContainerBegin(tagContainer: TagContainer) {
        _html.append("$currentIndentation<${tagContainer.tagName}>$linebreak")
        currentIndentation += indentation
    }

    override fun visitTagContainerEnd(tagContainer: TagContainer) {
        currentIndentation = currentIndentation.dropLast(1)
        visitTag(tagContainer)
    }

    override fun visitTextElement(element: TextElement) {
        _html.append("$currentIndentation${element.text}$linebreak")
    }
}

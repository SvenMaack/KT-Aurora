package lib.tags.base

import lib.tags.Tag

interface Visitor {
    fun visitTextElement(element: TextElement)
    fun visitTag(tag: Tag)
    fun visitTagWithAttributes(tag: TagWithAttributes)
    fun visitTagContainerBegin(tagContainer: TagContainer)
    fun visitTagContainerEnd(tagContainer: TagContainer)
}

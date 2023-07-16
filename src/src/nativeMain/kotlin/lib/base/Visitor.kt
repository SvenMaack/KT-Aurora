package lib.base

interface Visitor {
    fun visitTextElement(element: TextElement)
    fun visitTag(tag: Tag)
    fun visitTagContainerBegin(tagContainer: TagContainer)
    fun visitTagContainerEnd(tagContainer: TagContainer)
}

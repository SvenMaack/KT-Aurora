package template_lib.base

interface Visitor<RESULT> {
    val result: RESULT

    fun visitTag(tag: Tag)
    fun visitTagWithAttributes(tag: TagWithAttributes)
    fun visitTagContainerBegin(tagContainer: TagContainer)
    fun visitTagContainerEnd(tagContainer: TagContainer)
    fun visitTextElement(element: TextElement)
    fun visitComment(comment: Comment)
}

fun interface VisitorFactory<RESULT> {
    fun create(): Visitor<RESULT>
}

package template.base

public interface HtmlVisitor<RESULT> {
    public val result: RESULT

    public fun visitTag(tag: Tag)
    public fun visitComment(comment: Comment)
    public fun visitTagWithAttributes(tag: TagWithAttributes)
    public fun visitTagContainerBegin(tagContainer: TagContainer)
    public fun visitTagContainerEnd(tagContainer: TagContainer)
    public fun visitTextElement(element: TextElement)
}

public fun interface HtmlVisitorStrategy<RESULT> {
    public fun create(): HtmlVisitor<RESULT>
}

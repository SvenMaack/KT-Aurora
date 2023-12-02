package css.base

public class DocumentList: IDocument {
    internal val documents : MutableList<IDocument> = mutableListOf()

    override fun traverse(visitor: RuleVisitor<*>) {
        documents.forEach {
            it.traverse(visitor)
        }
    }

    public fun add(document: IDocument): DocumentList {
        documents.add(document)
        return this
    }

    public fun getDocumentAmount(): Int =
        documents.size
}

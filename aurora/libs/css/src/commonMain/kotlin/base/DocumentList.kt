package css_lib.base

class DocumentList: IDocument {
    internal val documents : MutableList<IDocument> = mutableListOf()

    override fun traverse(visitor: RuleVisitor<*>) {
        documents.forEach {
            it.traverse(visitor)
        }
    }

    fun add(document: IDocument): DocumentList {
        documents.add(document)
        return this
    }

    fun getDocumentAmount(): Int =
        documents.size
}

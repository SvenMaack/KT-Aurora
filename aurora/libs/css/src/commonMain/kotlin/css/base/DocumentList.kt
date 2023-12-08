package css.base

public class DocumentList: IDocument {
    internal val documents : MutableList<IDocument> = mutableListOf()

    override fun traverse(visitor: RuleVisitor<*>) {
        documents.forEach {
            it.traverse(visitor)
        }
    }

    public operator fun plus(document: IDocument): DocumentList {
        documents.add(document)
        return this
    }

    public operator fun IDocument.unaryPlus() {
        documents.add(this)
    }
}

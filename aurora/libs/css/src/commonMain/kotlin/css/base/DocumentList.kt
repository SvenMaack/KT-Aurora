package css.base

public class DocumentList: IDocument {
    internal val documents : MutableList<IDocument> = mutableListOf()

    override fun traverse(visitor: RuleVisitor<*>) {
        val documentSet: MutableSet<IDocument> = mutableSetOf()
        gatherDocuments(documentSet)
        documentSet.forEach {
            it.traverse(visitor)
        }
    }

    override fun gatherDocuments(set: MutableSet<IDocument>) {
        documents.forEach {
            it.gatherDocuments(set)
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

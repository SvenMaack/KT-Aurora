package css_lib.base

class DocumentComposite: Document() {
    private var _documents : MutableList<Document> = mutableListOf()
    internal val documents: List<Document> = _documents

    override fun traverse(visitor: RuleVisitor<*>) {
        super.traverse(visitor)
        _documents.forEach {
            it.traverse(visitor)
        }
    }

    fun addDocument(document: Document) {
        _documents.add(document)
    }
}

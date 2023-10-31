package css_lib.base

class DocumentComposite: Document() {
    internal val documents: MutableList<Document> = mutableListOf()

    override fun traverse(visitor: Visitor<*>) {
        super.traverse(visitor)
        documents.forEach { it.traverse(visitor) }
    }

    fun addDocument(document: Document) {
        documents.add(document)
    }
}

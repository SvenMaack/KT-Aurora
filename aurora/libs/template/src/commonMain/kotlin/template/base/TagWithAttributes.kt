package template.base

public open class TagWithAttributes(name: String):
    Tag(
        name.trim()
            .lowercase()
            .filter {
                it.isLetterOrDigit()
            }
            .ifEmpty {
                "empty"
            }
    ) {
    public var attributes: Map<String, List<String?>> = mapOf()

    override fun traverse(htmlVisitor: HtmlVisitor<*>) {
        htmlVisitor.visitTagWithAttributes(this)
    }

    public fun setAttributes(vararg attributes: Attribute): TagWithAttributes {
        this.attributes = attributes.groupBy({ it.name }, { it.value })
        return this
    }
}

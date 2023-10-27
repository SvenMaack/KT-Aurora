package template_lib.base

open class TagWithAttributes(name: String):
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
    internal var attributes: Map<String, List<String>> = mapOf()

    override fun traverse(visitor: Visitor<*>) {
        visitor.visitTagWithAttributes(this)
    }

    fun setAttributes(vararg attributes: Attribute): TagWithAttributes {
        this.attributes = attributes.filter { it.value !== null }.groupBy({ it.name }, { it.value!! })
        return this
    }
}

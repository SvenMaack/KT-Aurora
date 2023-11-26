package template_lib.base

public open class TagContainer(name: String) : TagWithAttributes(name) {
    @PublishedApi
    internal val mChildren: MutableList<Element> = mutableListOf()

    public val children: List<Element>
        get() = mChildren

    public inline fun <T : Element> add(tag: T, init: T.() -> Unit = {}): T = tag.apply {
        init()
        mChildren.add(this)
    }

    internal inline fun addAll(childs: List<Element>) {
        this.mChildren.addAll(childs)
    }

    override fun traverse(visitor: Visitor<*>) {
        visitor.visitTagContainerBegin(this)
        children.forEach { it.traverse(visitor) }
        visitor.visitTagContainerEnd(this)
    }

    public inline operator fun String.not(): Comment =
        add(Comment(this))
}

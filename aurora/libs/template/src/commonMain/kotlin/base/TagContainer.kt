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

    override fun traverse(htmlVisitor: HtmlVisitor<*>) {
        htmlVisitor.visitTagContainerBegin(this)
        children.forEach { it.traverse(htmlVisitor) }
        htmlVisitor.visitTagContainerEnd(this)
    }

    public inline operator fun String.not(): Comment =
        add(Comment(this))
}

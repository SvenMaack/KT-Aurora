package lib.tags.base

open class TagContainer(name: String) : TagWithAttributes(name) {
    @PublishedApi
    internal val mChildren: MutableCollection<Element> = mutableListOf()

    val children: Collection<Element>
        get() = mChildren

    inline fun <T : Element> add(tag: T, init: T.() -> Unit = {}): T = tag.apply {
        init()
        mChildren.add(this)
    }

    override fun traverse(visitor: Visitor) {
        visitor.visitTagContainerBegin(this)
        children.forEach { it.traverse(visitor) }
        visitor.visitTagContainerEnd(this)
    }

    inline operator fun String.not() = add(Comment(this))
}

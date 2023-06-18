package lib

class TagContainer(private val type: String): HtmlElement {
    override fun toString(): String =
        "<$type></$type>"
}

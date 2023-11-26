package template_lib.base

public open class TagWithText(name: String) : TagContainer(name) {
    public inline operator fun String.unaryPlus(): TextElement {
        val textElement = TextElement(this)
        add(textElement)
        return textElement
    }

    override fun traverse(visitor: Visitor<*>) {
        super.traverse(visitor)
        visitor.visitTagWithText(this)
    }
}

public class TextElement(public val text: String) : Element {
    override fun traverse(visitor: Visitor<*>) {
        visitor.visitTextElement(this)
    }
}

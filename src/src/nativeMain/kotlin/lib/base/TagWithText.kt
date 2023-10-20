package lib.base

open class TagWithText(name: String) : TagContainer(name) {
    inline operator fun String.unaryPlus(): TextElement {
        val textElement = TextElement(this)
        add(textElement)
        return textElement
    }
}

class TextElement(val text: String) : Element {
    override fun traverse(visitor: Visitor<*>) {
        visitor.visitTextElement(this)
    }
}

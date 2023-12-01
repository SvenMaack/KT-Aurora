package template.base

public open class TagWithText(name: String) : TagContainer(name) {
    public inline operator fun String.unaryPlus(): TextElement {
        val textElement = TextElement(this)
        add(textElement)
        return textElement
    }
}

public class TextElement(public val text: String) : Element {
    override fun traverse(htmlVisitor: HtmlVisitor<*>) {
        htmlVisitor.visitTextElement(this)
    }
}

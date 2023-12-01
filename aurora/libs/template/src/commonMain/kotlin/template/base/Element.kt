package template.base

public interface Element {
    public fun traverse(htmlVisitor: HtmlVisitor<*>)
}

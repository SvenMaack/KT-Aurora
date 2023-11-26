package template_lib.base

public interface Element {
    public fun traverse(htmlVisitor: HtmlVisitor<*>)
}

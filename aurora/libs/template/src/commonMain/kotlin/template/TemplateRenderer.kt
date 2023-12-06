package template

import template.base.Element
import template.base.HtmlVisitorStrategy

public class TemplateRenderer(private val htmlVisitorStrategy: HtmlVisitorStrategy<String>) : ITemplateRenderer {
    public override fun render(context: Context, template: Template<Unit>): String =
        render(context, template(context, Unit))

    public override fun <VM>render(context: Context, template: Template<VM>, vm: VM): String =
        render(context, template(context, vm))

    public override fun render(context: Context, element: Element): String =
        htmlVisitorStrategy.create().apply {
            element.traverse(this)
        }.result
}

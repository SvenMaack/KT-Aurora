package template_lib

import template_lib.base.Element

public class TemplateRenderer : ITemplateRenderer {
    public override fun render(context: Context, template: Template<Unit>): String =
        render(context, template(context, Unit))

    public override fun <DTO>render(context: Context, template: Template<DTO>, dto: DTO): String =
        render(context, template(context, dto))

    public override fun render(context: Context, element: Element): String =
        context.htmlVisitorStrategy.create().apply {
            element.traverse(this)
        }.result
}

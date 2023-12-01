package template_lib

import template_lib.base.Element

public interface ITemplateRenderer {
    public fun render(context: Context, template: Template<Unit>): String

    public fun <DTO>render(context: Context, template: Template<DTO>, dto: DTO): String

    public fun render(context: Context, element: Element): String
}

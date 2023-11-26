package template_lib

import template_lib.base.Element
import template_lib.base.TagContainer

public object TemplateRenderer {
    public inline fun <DTO>render(context: Context, dynamicTemplate: DynamicTemplate<DTO>, dto: DTO): String =
        dynamicTemplate(context, dto).render(context)

    public inline fun render(context: Context, tagContainer: TagContainer): String =
        tagContainer.render(context)

    public inline fun render(context: Context, template: StaticTemplate): String =
        template(context).render(context)

    public inline infix fun Element.render(context: Context): String {
        return context.visitorFactory.create().apply {
            traverse(this)
        }.result
    }
}

package template_lib

import template_lib.base.Element

object TemplateRenderer {
    inline fun <DTO>render(context: Context, dynamicTemplate: DynamicTemplate<DTO>, dto: DTO): String =
        dynamicTemplate(context, dto).rendering(context)

    inline fun render(context: Context, template: StaticTemplate): String =
        template(context).rendering(context)

    inline infix fun Element.rendering(context: Context): String {
        return context.visitorFactory.create().apply {
            traverse(this)
        }.result
    }
}

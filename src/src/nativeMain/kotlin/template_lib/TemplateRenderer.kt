package template_lib

object TemplateRenderer {
    inline fun <DTO>render(context: Context, dynamicTemplate: DynamicTemplate<DTO>, dto: DTO): String {
        val visitor = context.visitorFactory.create()
        dynamicTemplate(context, dto).traverse(visitor)
        return visitor.result
    }

    inline fun render(context: Context, template: StaticTemplate): String {
        val visitor = context.visitorFactory.create()
        template(context).traverse(visitor)
        return visitor.result
    }
}

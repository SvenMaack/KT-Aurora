package lib

object TemplateRenderer {
    fun <DTO>render(context: Context, template: Template<DTO>, dto: DTO): String {
        val visitor = context.visitorFactory.create()
        template(context, dto).traverse(visitor)
        return visitor.html
    }

    fun render(context: Context, template: StaticTemplate): String {
        val visitor = context.visitorFactory.create()
        template(context).traverse(visitor)
        return visitor.html
    }
}

package lib

object TemplateRenderer {
    inline fun <DTO>render(context: Context, dynamicTemplate: DynamicTemplate<DTO>, dto: DTO): String {
        val visitor = context.visitorFactory.create()
        dynamicTemplate(context, dto).traverse(visitor)
        return visitor.result
    }

    inline fun render(context: Context, template: StaticTemplate): String {
        val visitor = context.visitorFactory.create()
        val tagContainer = template(context)
        tagContainer.children.forEach {
            it.traverse(visitor)
        }
        return visitor.result
    }
}

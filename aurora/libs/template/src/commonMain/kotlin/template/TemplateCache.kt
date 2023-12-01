package template

internal object TemplateCache {
    private val cachedResult: MutableMap<String, String> = mutableMapOf()

    operator fun get(context: Context, template: Template<Unit>): String =
        cachedResult.getOrElse(getCacheKey(context, template)) {
            val result = context.templateRenderer.render(context, template, Unit)
            cachedResult[getCacheKey(context, template)] = result
            result
        }

    fun clear() {
        cachedResult.clear()
    }

    private fun getCacheKey(context: Context, template: Template<Unit>): String =
        context.hashCode().toString() + template.hashCode().toString()
}

package lib

internal object TemplateCache {
    private val cachedResult: MutableMap<String, String> = mutableMapOf()

    fun getOrSet(context: Context, template: StaticTemplate) =
        cachedResult.getOrElse(getCacheKey(context, template)) {
            val result = TemplateRenderer.render(context, template)
            cachedResult[getCacheKey(context, template)] = result
            result
        }

    fun clear() {
        cachedResult.clear()
    }

    private fun getCacheKey(context: Context, template: StaticTemplate): String =
        context.hashCode().toString() + template.hashCode().toString()
}

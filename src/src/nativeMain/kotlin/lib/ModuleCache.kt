package lib

object ModuleCache {
    private val cachedResult: MutableMap<String, String> = mutableMapOf()

    fun getOrSet(context: Context, template: StaticTemplate, default: (Context, StaticTemplate) -> String) =
        cachedResult.getOrElse(getCacheKey(context, template)) {
            val result = default(context, template)
            cachedResult[getCacheKey(context, template)] = result
            result
        }

    private fun getCacheKey(context: Context, template: StaticTemplate): String =
        context.hashCode().toString() + template.hashCode().toString()
}

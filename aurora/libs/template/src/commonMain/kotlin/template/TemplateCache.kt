package template

import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import template.base.TagContainer
import template.base.TransientTag

public fun <P: TagContainer>P.cache(context: Context, template: StaticTemplateExtension<P>, ref: () -> P) {
    add(TransientTag().apply {
        +TemplateCache[context, template, ref]
    })
}

internal object TemplateCache {
    private val cachedResult: MutableMap<String, String> = mutableMapOf()

    operator fun <P: TagContainer>get(context: Context, template: StaticTemplateExtension<P>, ref: () -> P): String =
        cachedResult.getOrElse(getCacheKey(context, template)) {
            val content: TagContainer = createCacheableTag(context, template, ref)
            context.templateRenderer.render(context, content).apply {
                cachedResult[getCacheKey(context, template)] = this
            }
        }

    internal fun clear() {
        cachedResult.clear()
    }

    private fun getCacheKey(context: Context, template: StaticTemplateExtension<*>): String =
        context.hashCode().toString() + template.hashCode().toString()

    private fun <P: TagContainer>createCacheableTag(context: Context, template: StaticTemplateExtension<P>, ref: () -> P): TransientTag =
        TransientTag().apply {
            val timestamp = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).time
            val renderingResult = renderTemplateExtension(context, template, ref)

            !"Rendering starts at - $timestamp"
            addAll(renderingResult.children)
            !"Rendering of $timestamp ended"
        }

    private fun <P>renderTemplateExtension(context: Context, template: StaticTemplateExtension<P>, ref: () -> P): P =
        ref().apply {
            template(context, Unit)
        }
}

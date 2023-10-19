package lib

import lib.tags.base.*
import kotlin.system.getTimeNanos

class ModuleTag: TransientTag()

interface Module<DTO> {
    val template: Template<DTO>
}

inline infix fun <T: Element>T.with(init: T.() -> Unit): ModuleTag =
    ModuleTag().apply {
        add(this@with, init)
    }

inline fun <M: Module<M>>TagContainer.include(context: Context, module: M) {
    add(module.template(context, module))
}

fun TagContainer.include(context: Context, template: StaticTemplate) {
    add(TransientTag().apply {
        val timestamp = getTimeNanos()
        !"Cache start - $timestamp"
        + cachedResult.getOrElse(getCacheKey(context, template)) {
            println("no cache")
            val result = renderTemplate(context, template)
            cachedResult[getCacheKey(context, template)] = result
            result
        }
        !"Cache end   - $timestamp"
    })
}

private fun renderTemplate(context: Context, template: StaticTemplate): String {
    val visitor = context.visitorFactory.getVisitor()
    val element = template(context)
    element.traverse(visitor)
    return visitor.html
}

private fun getCacheKey(context: Context, template: StaticTemplate): String =
    context.hashCode().toString() + template.hashCode().toString()

private val cachedResult: MutableMap<String, String> = mutableMapOf()
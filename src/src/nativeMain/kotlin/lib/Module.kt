package lib

import lib.tags.base.*
import kotlin.system.getTimeNanos

interface Module<DTO> {
    val template: Template<DTO>
}

inline infix fun <T: Element>T.with(init: T.() -> Unit): TransientTag =
    TransientTag().apply {
        add(this@with, init)
    }

inline fun <M: Module<M>>TagContainer.include(context: Context, module: M) {
    add(module.template(context, module))
}

fun TagContainer.include(context: Context, template: StaticTemplate) {
    add(TransientTag().apply {
        val timestamp = getTimeNanos()
        !"Cache start - $timestamp"
        +ModuleCache.getOrSet(context, template, ::renderTemplate)
        !"Cache end   - $timestamp"
    })
}

private fun renderTemplate(context: Context, template: StaticTemplate): String {
    val visitor = context.visitorFactory.getVisitor()
    val element = template(context)
    element.traverse(visitor)
    return visitor.html
}
package lib

import lib.base.Element
import lib.base.TagContainer
import lib.base.TransientTag
import kotlin.system.getTimeNanos

interface Module<DTO> {
    val template: Template<DTO>
}

//creation of module
inline infix fun <T: Element>T.with(init: T.() -> Unit): TransientTag =
    TransientTag().apply {
        add(this@with, init)
    }

inline fun <M: Module<M>> TagContainer.include(context: Context, module: M) {
    add(module.template(context, module))
}

fun TagContainer.include(context: Context, template: StaticTemplate) {
    add(TransientTag().apply {
        val timestamp = getTimeNanos()
        !"Cache start - $timestamp"
        +ModuleCache.getOrSet(context, template, TemplateRenderer::render)
        !"Cache end   - $timestamp"
    })
}

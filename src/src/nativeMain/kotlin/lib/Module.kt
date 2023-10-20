package lib

import lib.base.TagContainer
import lib.base.TransientTag
import kotlin.system.getTimeNanos

interface Module<DTO> {
    val dynamicTemplate: DynamicTemplate<DTO>
}

//creation of module
inline infix fun <T: TagContainer>T.with(init: T.() -> Unit): TransientTag =
    TransientTag().apply {
        add(this@with, init)
    }

inline fun <T: TagContainer>childrenOf(tag: T, init: T.() -> Unit): T {
    tag.init()
    return tag
}

inline fun <M: Module<M>> TagContainer.include(context: Context, module: M) {
    module.dynamicTemplate(context, module).children.forEach {
        add(it)
    }
}

fun TagContainer.include(context: Context, template: StaticTemplate) {
    add(TransientTag().apply {
        val timestamp = getTimeNanos()
        !"Cache start - $timestamp"
        +ModuleCache.getOrSet(context, template, TemplateRenderer::render)
        !"Cache end   - $timestamp"
    })
}

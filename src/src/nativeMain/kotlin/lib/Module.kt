package lib

import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import lib.base.TagContainer
import lib.base.TransientTag

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

//include
inline fun <M: Module<M>> TagContainer.include(context: Context, module: M) {
    module.dynamicTemplate(context, module).children.forEach {
        add(it)
    }
}
fun TagContainer.include(context: Context, template: StaticTemplate) {
    add(TransientTag().apply {
        val timestamp = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).time
        !"Cache start - $timestamp"
        +ModuleCache.getOrSet(context, template, TemplateRenderer::render)
        !"Cache end   - $timestamp"
    })
}

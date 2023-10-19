package lib.tags

import lib.StaticTemplate
import lib.Template
import lib.tags.base.Element
import lib.tags.base.TagContainer
import lib.tags.base.TransientTag
import kotlin.system.getTimeNanos

class ModuleTag: TransientTag()

interface Module<DTO> {
    val template: Template<DTO>
}

inline infix fun <T: Element>T.with(init: T.() -> Unit): ModuleTag =
    ModuleTag().apply {
        add(this@with, init)
    }

inline fun <M: Module<M>>TagContainer.include(module: M) {
    add(module.template(module))
}

fun TagContainer.include(template: StaticTemplate) {
    add(TransientTag().apply {
        val timestamp = getTimeNanos()
        !"Cache start - $timestamp"
        + cachedResult.getOrElse(template) {
            val result = renderTemplate(template)
            cachedResult[template] = result
            result
        }
        !"Cache end   - $timestamp"
    })
}

private fun renderTemplate(template: StaticTemplate): String {
    val visitor = DebugVisitor()
    val element = template()
    element.traverse(visitor)
    return (DebugVisitor.LINE_BREAK + visitor.html)
}

private val cachedResult: MutableMap<StaticTemplate, String> = mutableMapOf()
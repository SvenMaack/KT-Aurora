package lib.tags

import lib.StaticTemplate
import lib.tags.base.Element
import lib.tags.base.TagContainer
import lib.tags.base.Visitor

class ModuleTag: TagContainer("") {
    override fun traverse(visitor: Visitor) {
        children.forEach { it.traverse(visitor) }
    }
}

interface Module {
    val template: Element
}

inline infix fun <T: Element>T.with(init: T.() -> Unit): ModuleTag =
    ModuleTag().apply {
        add(this@with, init)
    }

inline fun <M: Module>TagContainer.include(module: M) {
    add(module.template)
}

inline fun TagContainer.include(template: StaticTemplate) {
    add(template())
}

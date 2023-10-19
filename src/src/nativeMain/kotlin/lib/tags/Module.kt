package lib.tags

import lib.StaticTemplate
import lib.Template
import lib.tags.base.Element
import lib.tags.base.TagContainer
import lib.tags.base.TransientTag

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

inline fun TagContainer.include(template: StaticTemplate) {
    add(template())
}

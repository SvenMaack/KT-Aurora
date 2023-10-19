package example

import lib.Template
import lib.tags.Head
import lib.tags.Module
import lib.tags.base.Element
import lib.tags.with

data class HeadDto(
    val title: String
): Module {
    override val template: Element
        get() = HeadModule(this)
}

val HeadModule: Template<HeadDto> = { data ->
    Head() with {
        title {
            +data.title
        }
        meta(name="viewport", content="width=device-width, initial-scale=1")
        meta(charset="UTF-8")
        meta(name="description", content="Put your description here.")
    }
}

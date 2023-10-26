package example

import lib.*
import lib.tags.Head

data class HeadDto(
    val title: String,
    override val dynamicTemplate: DynamicTemplate<HeadDto> = HeadModule
): Module<HeadDto>

val HeadModule: DynamicTemplate<HeadDto> = { context, data ->
    Head() with {
        include(template=StaticHead, context=context)
        title {
            +data.title
        }
        meta(name="description", content="Put your description here.")
        meta(name="keywords", content="Put your description here.")
    }
}

val StaticHead: StaticTemplate = { _ ->
    childrenOf(Head()) {
        meta(charset="UTF-8")
        meta(name="viewport", content="width=device-width, initial-scale=1")
    }
}
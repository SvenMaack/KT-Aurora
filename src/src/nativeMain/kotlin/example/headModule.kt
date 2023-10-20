package example

import lib.*
import lib.tags.Head

data class HeadDto(
    val title: String,
    override val dynamicTemplate: DynamicTemplate<HeadDto> = HeadModule
): Module<HeadDto>

val HeadModule: DynamicTemplate<HeadDto> = { context, data ->
    Head() with {
        title {
            +data.title
        }
        meta(name="description", content="Put your description here.")
        include(template=StaticHead, context=context)
    }
}

val StaticHead: StaticTemplate = { _ ->
    childrenOf(Head()) {
        meta(name="viewport", content="width=device-width, initial-scale=1")
        meta(charset="UTF-8")
    }
}
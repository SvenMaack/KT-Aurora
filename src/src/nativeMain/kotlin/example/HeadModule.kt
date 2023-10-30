package example

import template_lib.*
import template_lib.tags.Head

data class HeadDto(
    val title: String
)

val HeadModule: DynamicTemplate<HeadDto> = { context, data ->
    Head().apply {
        include(context=context, template=StaticHead)
        include(context=context, template=DynamicHead, dto=data)
    }
}

val DynamicHead: DynamicTemplate<HeadDto> = { _, data ->
    Head().childs {
        title {
            +data.title
        }
        meta(name="description", content="Put your description here.")
        meta(name="keywords", content="Put your keywords here.")
    }
}

val StaticHead: StaticTemplate = { _ ->
    Head().childs {
        meta(charset="UTF-8")
        meta(name="viewport", content="width=device-width, initial-scale=1")
        link(rel="stylesheet", href="test.css")
    }
}
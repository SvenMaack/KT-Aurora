package example

import template_lib.DynamicTemplate
import template_lib.include
import template_lib.tags.*

data class PageDto(
    val headDto: HeadDto
)

val PageModule: DynamicTemplate<PageDto> = { context, data ->
    html(lang="en") {
        include(context=context, template=HeadModule, dto=data.headDto)
        include(context=context, template=BodyModule)
    }
}

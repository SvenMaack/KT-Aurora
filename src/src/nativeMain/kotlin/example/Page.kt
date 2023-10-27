package example

import lib.DynamicTemplate
import lib.include
import lib.tags.*

data class PageDto(
    val headDto: HeadDto
)

val PageModule: DynamicTemplate<PageDto> = { context, data ->
    html(lang="en") {
        include(context=context, template=HeadModule, dto=data.headDto)
        include(context=context, template=BodyModule)
    }
}

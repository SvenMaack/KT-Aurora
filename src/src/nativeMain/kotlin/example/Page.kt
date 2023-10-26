package example

import lib.Module
import lib.DynamicTemplate
import lib.include
import lib.tags.*

data class PageDto(
    val headDto: HeadDto,
    override val dynamicTemplate: DynamicTemplate<PageDto> = PageModule
): Module<PageDto>

val PageModule: DynamicTemplate<PageDto> = { context, data ->
    html(lang="en") {
        include(module=data.headDto, context=context)
        include(template=BodyModule, context=context)
    }
}

package example

import lib.Module
import lib.Template
import lib.include
import lib.tags.*

data class PageDto(
    val headDto: HeadDto,
    override val template: Template<PageDto> = PageModule
): Module<PageDto>

val PageModule: Template<PageDto> = { context, data ->
    html(lang = "en") {
        include(context=context, module=data.headDto)
        include(context=context, template=BodyModule)
    }
}

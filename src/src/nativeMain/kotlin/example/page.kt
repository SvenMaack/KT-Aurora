package example

import lib.Module
import lib.Template
import lib.include
import lib.tags.*

data class PageDto(
    val headDto: HeadDto,
    override val template: Template<PageDto> = PageModule
): Module<PageDto>

val PageModule: Template<PageDto> = { data ->
    html(lang = "en") {
        include(module=data.headDto)
        include(template=BodyModule)
    }
}

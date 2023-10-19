package example

import lib.tags.*
import lib.tags.base.Element

val page1: (HeadDto) -> Element = { headData ->
    html(lang="en") {
        include(module=headData)
        include(template=BodyModule)
    }
}



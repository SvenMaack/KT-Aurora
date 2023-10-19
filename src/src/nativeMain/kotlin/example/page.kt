package example

import lib.tags.*
import lib.tags.base.Element

val page: (HeadDto) -> Element = { headData ->
    html(lang="en") {
        include(module=headData)
        include(template=BodyModule)
    }
}

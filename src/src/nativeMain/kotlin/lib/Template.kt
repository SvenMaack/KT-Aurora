package lib

import lib.tags.base.Element

typealias Template<DTO> = (data: DTO) -> Element
typealias StaticTemplate = (Unit) -> Element

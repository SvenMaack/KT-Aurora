package lib

import lib.base.Element

typealias Template<DTO> = (context: Context, data: DTO) -> Element
typealias StaticTemplate = (context: Context) -> Element

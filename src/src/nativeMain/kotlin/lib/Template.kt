package lib

import lib.base.TagContainer

typealias DynamicTemplate<DTO> = (context: Context, data: DTO) -> TagContainer
typealias StaticTemplate = (context: Context) -> TagContainer

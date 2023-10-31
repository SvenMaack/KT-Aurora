package page_lib

import css_lib.base.Document
import template_lib.DynamicTemplate
import template_lib.StaticTemplate

interface StaticModule {
    val document: Document
    val template: StaticTemplate
}

interface DynamicModule<DTO> {
    val document: Document
    val template: DynamicTemplate<DTO>
}

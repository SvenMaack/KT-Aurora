package page_lib

import css_lib.base.IDocument
import template_lib.DynamicTemplate
import template_lib.StaticTemplate

interface StaticModule {
    val document: IDocument
    val template: StaticTemplate
}

interface DynamicModule<DTO> {
    val document: IDocument
    val template: DynamicTemplate<DTO>
}

package page_lib

import css.base.IDocument
import template.Template

interface Module<DTO> {
    val document: IDocument
    val template: Template<DTO>
}

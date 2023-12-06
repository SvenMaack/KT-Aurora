package page_lib

import css.base.IDocument
import template.Template
import template.TemplateExtension

data class Module<TAG, VM> (
    val document: IDocument,
    val template: TemplateExtension<TAG, VM>
)

data class PageModule<VM> (
    val document: IDocument,
    val template: Template<VM>
)

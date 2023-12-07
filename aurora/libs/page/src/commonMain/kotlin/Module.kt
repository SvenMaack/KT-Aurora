package page_lib

import css.base.EmptyDocument
import css.base.IDocument
import template.Template
import template.TemplateExtension
import template.base.TransientTag

data class Module<TAG, VM> (
    val document: IDocument = EmptyDocument,
    val template: TemplateExtension<TAG, VM> = { _, _ -> }
)

data class PageModule<VM> (
    val document: IDocument = EmptyDocument,
    val template: Template<VM> = { _, _ -> TransientTag()}
)

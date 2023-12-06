package page_lib

import css.base.IDocument
import template.Template
import template.TemplateExtension

interface Module<TAG, VM> {
    val document: IDocument
    val template: TemplateExtension<TAG, VM>
}

interface PageModule<VM> {
    val document: IDocument
    val template: Template<VM>
}

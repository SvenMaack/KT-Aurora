package head

import css.base.EmptyDocument
import css.base.IDocument
import head.code.SimpleHeadTemplate
import page_lib.Module
import template.TemplateExtension
import template.tags.Html

public val HeadModule: Module<Html, Head> = object : Module<Html, Head> {
    override val document: IDocument =
        EmptyDocument
    override val template: TemplateExtension<Html, Head> =
        SimpleHeadTemplate
}



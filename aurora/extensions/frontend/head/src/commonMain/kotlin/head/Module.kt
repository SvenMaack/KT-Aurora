package head

import css.base.EmptyDocument
import css.base.IDocument
import head.code.SimpleHeadTemplate
import page_lib.Module
import template.Template

public val HeadModule: Module<Head> = object : Module<Head> {
    override val document: IDocument =
        EmptyDocument
    override val template: Template<Head> =
        SimpleHeadTemplate
}



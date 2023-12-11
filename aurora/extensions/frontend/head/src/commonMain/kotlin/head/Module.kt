package head

import css.base.EmptyDocument
import page.Module
import template.tags.Html

public val HeadModule: Module<Html, TechnicalData> =
    Module(EmptyDocument, SimpleHeadTemplate)

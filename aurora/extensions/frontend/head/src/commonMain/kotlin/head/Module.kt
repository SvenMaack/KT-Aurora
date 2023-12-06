package head

import css.base.EmptyDocument
import page_lib.Module
import template.tags.Html

public val HeadModule: Module<Html, TechnicalData> =
    Module(EmptyDocument, SimpleHeadTemplate)

package base

import css_lib.base.IDocument
import css_lib.base.RuleVisitorFactory

object CssRenderer {
    inline fun <RESULT>render(ruleVisitorFactory: RuleVisitorFactory<RESULT>, document: IDocument): RESULT =
        ruleVisitorFactory.create().apply {
            document.traverse(this)
        }.result
}

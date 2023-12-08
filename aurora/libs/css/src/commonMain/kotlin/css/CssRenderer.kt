package css

import css.base.IDocument
import css.base.RuleVisitorFactory

public object CssRenderer {
    public inline fun <RESULT>render(ruleVisitorFactory: RuleVisitorFactory<RESULT>, document: IDocument): RESULT =
        ruleVisitorFactory.create().apply {
            document.traverse(this)
        }.result
}

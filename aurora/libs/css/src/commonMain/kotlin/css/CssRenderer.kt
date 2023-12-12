package css

import css.base.IDocument
import css.base.RuleVisitorFactory

public interface ICssRenderer<RESULT> {
    public fun render(ruleVisitorFactory: RuleVisitorFactory<RESULT>, document: IDocument): RESULT
}

public open class CssRenderer<RESULT>: ICssRenderer<RESULT> {
    public override fun render(ruleVisitorFactory: RuleVisitorFactory<RESULT>, document: IDocument): RESULT =
        ruleVisitorFactory.create().apply {
            document.traverse(this)
        }.result
}

package css.base

public object CssRenderer {
    public inline fun <RESULT>render(ruleVisitorFactory: RuleVisitorFactory<RESULT>, document: IDocument): RESULT =
        ruleVisitorFactory.create().apply {
            document.traverse(this)
        }.result
}

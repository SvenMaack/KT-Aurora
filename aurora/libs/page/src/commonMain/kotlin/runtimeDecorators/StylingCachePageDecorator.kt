package page_lib.runtimeDecorators

import css_lib.base.RuleVisitorFactory
import page_lib.IPage

class StylingCachePageDecorator(private val inner: IPage, private val ruleVisitorFactory: RuleVisitorFactory<String>)
    : IPage by inner {
    private val cachedInnerStyling: Lazy<String> = lazy {
        inner.getInternalCss(ruleVisitorFactory)
    }

    private val cachedExternalStyling: Lazy<String> = lazy {
        inner.getExternalCss(ruleVisitorFactory)
    }

    override fun getExternalCss(ruleVisitorFactory: RuleVisitorFactory<String>): String  =
        cachedExternalStyling.value

    override fun getInternalCss(ruleVisitorFactory: RuleVisitorFactory<String>): String  =
        cachedInnerStyling.value
}

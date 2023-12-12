package page

import css.base.IDocument
import template.Template

public fun interface InlineCssProvider {
    public fun getInlineCssDocument(): IDocument
}
public fun interface ExternalCssProvider {
    public fun getExternalCssDocument(): IDocument
}
public interface CssProvider: InlineCssProvider, ExternalCssProvider

public fun interface HtmlProvider<ViewModel> {
    public fun getTemplate(): Template<ViewModel>
}

public interface IPageProvider<ViewModel>: HtmlProvider<ViewModel>, CssProvider {
    public companion object {
        public fun <ViewModel> build(
            inlineCss: IDocument,
            externalCss: IDocument,
            template: Template<ViewModel>
        ): IPageProvider<ViewModel> =
            object : IPageProvider<ViewModel> {
                override fun getInlineCssDocument(): IDocument =
                    inlineCss

                override fun getExternalCssDocument(): IDocument =
                    externalCss

                override fun getTemplate(): Template<ViewModel> =
                    template
            }

    }
}

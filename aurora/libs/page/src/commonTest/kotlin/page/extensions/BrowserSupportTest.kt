package page.extensions

import css.ICssRenderer
import css.base.Document
import css.base.Property
import css.base.RuleVisitorFactory
import css.base.browser.NOT_SUPPORTED
import css.base.browser.SupportData
import io.mockative.Mock
import io.mockative.classOf
import io.mockative.every
import io.mockative.mock
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BrowserSupportTest {
    @Mock
    val cssRendererMock = mock(classOf<ICssRenderer<String>>())
    @Mock
    val ruleVisitorMock = mock(classOf<RuleVisitorFactory<String>>())

    @Test
    fun `browserSupport works`() {
        val document = Document().apply {
            this["test"] = {
                +Property("p", "v", SupportData(
                    1.0,
                    2.0,
                    3.0,
                    4.0,
                    5.0
                ))
            }
        }
        every { cssRendererMock.render(ruleVisitorMock, document) }.returns("test")

        val browserSupport = BrowserSupport(cssRendererMock)

        val result = browserSupport.render(ruleVisitorMock, document)

        assertEquals("/*chrome>=1.0,firefox>=3.0,edge>=2.0,safari>=5.0,opera>=4.0*/\ntest", result)
    }

    @Test
    fun `browserSupport works wiht unsupported Property`() {
        val document = Document().apply {
            this["test"] = {
                +Property("p", "v", SupportData(
                    NOT_SUPPORTED,
                    2.0,
                    3.0,
                    4.0,
                    5.0
                ))
            }
        }
        every { cssRendererMock.render(ruleVisitorMock, document) }.returns("test")

        val browserSupport = BrowserSupport(cssRendererMock)

        val result = browserSupport.render(ruleVisitorMock, document)

        assertEquals("/*chrome is not supported,firefox>=3.0,edge>=2.0,safari>=5.0,opera>=4.0*/\ntest", result)
    }

    @Test
    fun `browserSupport works with multiple properties`() {
        val document = Document().apply {
            this["test"] = {
                +Property("p", "v", SupportData(
                    1.0,
                    2.0,
                    3.0,
                    4.0,
                    9.0
                ))
                +Property("p", "v", SupportData(
                    5.0, //<--
                    2.0,
                    3.0,
                    4.0,
                    5.0 //<--
                ))
            }
        }
        every { cssRendererMock.render(ruleVisitorMock, document) }.returns("test")

        val browserSupport = BrowserSupport(cssRendererMock)

        val result = browserSupport.render(ruleVisitorMock, document)

        assertEquals("/*chrome>=5.0,firefox>=3.0,edge>=2.0,safari>=9.0,opera>=4.0*/\ntest", result)
    }

    @Test
    fun `browserSupport works without properties`() {
        val document = Document().apply {
        }
        every { cssRendererMock.render(ruleVisitorMock, document) }.returns("test")

        val browserSupport = BrowserSupport(cssRendererMock)

        val result = browserSupport.render(ruleVisitorMock, document)

        assertEquals("/*chrome>=0.0,firefox>=0.0,edge>=0.0,safari>=0.0,opera>=0.0*/\ntest", result)
    }
}
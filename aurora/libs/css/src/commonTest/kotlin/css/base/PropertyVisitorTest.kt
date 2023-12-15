package css.base

import css.base.browser.SupportData
import io.mockative.*
import kotlin.test.Test

class PropertyVisitorTest {
    @Mock
    val visitPropertyMock = mock(classOf<Fun1<IProperty, Unit>>())

    private val visitor: PropertyVisitor<String> = object: PropertyVisitor<String>() {
        override fun visitProperty(property: IProperty): PropertyVisitor<String> {
            visitPropertyMock.invoke(property)
            return this
        }

        override val result: String = ""
    }

    @Test
    fun `test properties are visited`() {
        every { visitPropertyMock.invoke(any()) }.returns(Unit)
        val document = Document()
        val property = Property("property", "value", SupportData())
        document.apply {
            clazz["c1"] = {
                +property
            }
        }

        visitor.visitRule(document.rules[0])

        verify { visitPropertyMock.invoke(property) }
            .wasInvoked(exactly = once)
    }
}

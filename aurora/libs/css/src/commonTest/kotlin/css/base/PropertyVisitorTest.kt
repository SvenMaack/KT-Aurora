package css.base

import io.mockative.*
import kotlin.test.Test

class PropertyVisitorTest {
    @Mock
    val visitPropertyMock = mock(classOf<Fun1<Property, Unit>>())

    private val visitor: PropertyVisitor<String> = object: PropertyVisitor<String>() {
        override fun visitProperty(property: Property): PropertyVisitor<String> {
            visitPropertyMock.invoke(property)
            return this
        }

        override val result: String = ""
    }

    @Test
    fun `test properties are visited`() {
        every { visitPropertyMock.invoke(any()) }.returns(Unit)
        val document = Document()
        val property = Property("property", "value", listOf())
        document["selector"] = {
            +property
        }

        visitor.visitRule(document.rules[0])

        verify { visitPropertyMock.invoke(property) }
            .wasInvoked(exactly = once)
    }
}

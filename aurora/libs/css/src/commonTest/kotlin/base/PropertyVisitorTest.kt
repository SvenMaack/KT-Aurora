package css_lib.base

import Callable
import io.mockative.*
import kotlin.test.Test

class PropertyVisitorTest {
    @Mock
    val visitPropertyMock = mock(classOf<Callable<Property>>())

    val visitor: RuleVisitor<String> = object: PropertyVisitor<String>() {
        override fun visitProperty(property: Property): PropertyVisitor<String> {
            visitPropertyMock.test(property)
            return this
        }

        override val result: String = ""
    }

    @Test
    fun `test properties are visited`() {
        val document = Document()
        val property = Property.build("property", "value")
        document["selector"] = {
            +property
        }

        visitor.visitRule(document.rules[0])

        verify { visitPropertyMock.test(property) }
            .wasInvoked(exactly = once)
    }
}

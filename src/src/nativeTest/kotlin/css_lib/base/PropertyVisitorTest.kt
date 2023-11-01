package css_lib.base

import io.mockative.*
import template_lib.tags.Callable
import kotlin.test.Test

class PropertyVisitorTest {
    @Mock
    val visitPropertyMock = mock(classOf<Callable<Property>>())

    val visitor: RuleVisitor<String> = object: PropertyVisitor<String>() {
        override fun visitProperty(property: Property) {
            visitPropertyMock.test(property)
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

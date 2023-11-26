package template_lib.visitors

import kotlin.test.Test
import kotlin.test.assertEquals

class AttributeRendererTest {
    @Test
    fun `simple attribute list is rendered correctly`() {
        val attributes = mapOf("a" to listOf("b"))

        assertEquals(
            "a=\"b\"",
            AttributeRenderer.renderAttributes(attributes)
        )
    }

    @Test
    fun `multiple attribute list is rendered correctly`() {
        val attributes = mapOf("a" to listOf("b"), "c" to listOf("d"))

        assertEquals(
            "a=\"b\" c=\"d\"",
            AttributeRenderer.renderAttributes(attributes)
        )
    }

    @Test
    fun `multiple attribute list with multiple values is rendered correctly`() {
        val attributes = mapOf("a" to listOf("b"), "c" to listOf("d", "e"))

        assertEquals(
            "a=\"b\" c=\"d e\"",
            AttributeRenderer.renderAttributes(attributes)
        )
    }

    @Test
    fun `attributes without values are rendered correctly`() {
        val attributes = mapOf("a" to listOf("b"), "c" to listOf(null))

        assertEquals(
            "a=\"b\" c",
            AttributeRenderer.renderAttributes(attributes)
        )
    }
}
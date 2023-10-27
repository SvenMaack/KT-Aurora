package template_lib.tags

import io.mockative.*
import kotlin.test.Test
import kotlin.test.assertEquals

class HeadTest {
    @Mock
    val blockTitle = mock(classOf<Callable<Title>>())

    @Test
    fun `test tag name is head`() {
        val tag = Head()
        assertEquals("head", tag.name)
    }

    @Test
    fun `test title function works`() {
        val head = Head()
        val title = head.title(init = blockTitle::test)

        verify { blockTitle.test(title) }
            .wasInvoked(exactly = once)
    }

    @Test
    fun `test meta charset function works`() {
        val head = Head()
        val meta = head.meta(charset = "test")
        assertEquals(mapOf(
            "charset" to listOf("test"),
        ), meta.attributes)
    }

    @Test
    fun `test meta name-content function works`() {
        val head = Head()
        val meta = head.meta(name = "name", content = "content")
        assertEquals(mapOf(
            "name" to listOf("name"),
            "content" to listOf("content")
        ), meta.attributes)
    }
}

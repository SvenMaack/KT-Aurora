package template_lib.tags

import kotlin.test.Test
import kotlin.test.assertEquals

class ArticleTest {
    @Test
    fun `tag name is article`() {
        val tag = Article()
        assertEquals("article", tag.name)
    }
}

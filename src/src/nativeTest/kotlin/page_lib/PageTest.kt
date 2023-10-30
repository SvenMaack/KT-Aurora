package page_lib

import css_lib.base.Document
import io.mockative.*
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.cValue
import platform.posix.nanosleep
import platform.posix.timespec
import template_lib.DynamicTemplate
import template_lib.base.TagContainer
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class PageTest {
    @OptIn(ExperimentalForeignApi::class)
    @Test
    fun `id stays the same within instance`() {
        val page = Page<String>({ _, _ ->
            TagContainer("a")
        }, Document())
        val id = page.getId()
        val time = cValue<timespec> {
            tv_sec = 0
            tv_nsec = 2_000_000
        }
        nanosleep(time, null)
        assertEquals(id, page.getId())
    }

    @Test
    fun `id is unique`() {
        val page1 = Page<String>({ _, _ ->
            TagContainer("a")
        }, Document())
        val page2 = Page<String>({ _, _ ->
            TagContainer("a")
        }, Document())
        assertNotEquals(page1.getId(), page2.getId())
    }
}

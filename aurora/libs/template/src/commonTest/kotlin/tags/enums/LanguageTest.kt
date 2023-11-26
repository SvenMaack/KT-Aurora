package template_lib.tags.enums

import kotlin.test.Test
import kotlin.test.assertEquals

class LanguageTest {
    @Test
    fun `language set correctly`() {
        val language = GeneralLanguage.English + CountryCode.UNITED_STATES
        assertEquals("en-US", language.value)
    }
}

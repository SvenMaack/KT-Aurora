package page

import kotlin.test.Test
import kotlin.test.assertEquals

class ClassGeneratorTest {
    @Test
    fun generate() {
        val generator = IdentifierGenerator(Anagram.abc.name)
        val expected = listOf(
            "a",
            "b",
            "c",
            "aa",
            "ab",
            "ac",
            "ba",
            "bb",
            "bc",
            "ca",
            "cb",
            "cc",
            "aaa",
            "aab",
            "aac",
        )
        assertEquals(expected, expected.map { generator() })
    }

    @Test
    fun `generate binary`() {
        val generator = IdentifierGenerator(Anagram.`01`.name)
        val expected = listOf(
            "0",
            "1",
            "00",
            "01",
            "10",
            "11",
            "000",
            "001",
            "010",
            "011",
            "100",
            "101",
            "110",
            "111",
            "0000",
            "0001",
            "0010",
        )
        assertEquals(expected, expected.map { generator() })
    }

    @Test
    fun `generate decimal`() {
        val generator = IdentifierGenerator(Anagram.`0123456789`.name)
        val expected = listOf(
            "0",
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "00",
            "01",
            "02",
            "03",
            "04",
            "05",
            "06",
            "07",
            "08",
            "09",
            "10",
        )
        assertEquals(expected, expected.map { generator() })
    }

    @Test
    fun `generate empty`() {
        val generator = IdentifierGenerator("")
        val expected = listOf(
            "a",
            "aa",
            "aaa",
            "aaaa",
        )
        assertEquals(expected, expected.map { generator() })
    }
}

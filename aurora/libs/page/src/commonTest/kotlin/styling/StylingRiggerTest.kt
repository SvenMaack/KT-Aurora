package page_lib.styling

import css_lib.base.Document
import io.mockative.*
import kotlin.test.Test

class StylingRiggerTest {
    @Mock
    val riggerMock = mock(classOf<StylingRigger>())

    @Test
    fun `test Rigger List calls each element`() {
        val document = Document()
        val riggerList = RiggerList(listOf(riggerMock, riggerMock))
        every { riggerMock.rig(document) }.returns(document)

        riggerList.rig(document)

        verify { riggerMock.rig(document) }
            .wasInvoked(exactly = twice)
    }
}

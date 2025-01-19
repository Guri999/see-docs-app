package kr.co.data.repository

import io.mockk.MockKAnnotations
import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.just
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import kr.co.data.dummy.TestDummy
import kr.co.data.mapper.BookmarkFileMapper
import kr.co.data.mapper.FileInfoMapper
import kr.co.database.dao.BookmarkFileDao
import kr.co.testing.util.testWithItem
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

internal class BookmarkRepositoryImplTest {

    @MockK
    private lateinit var dao: BookmarkFileDao

    @MockK
    private lateinit var toBookmark : BookmarkFileMapper

    @MockK
    private lateinit var toFileInfo : FileInfoMapper

    private lateinit var repository: BookmarkRepository

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        repository = BookmarkRepositoryImpl(dao, toBookmark, toFileInfo)
    }

    @Test
    fun `Given a file when insert is called then dao insert is called`() = runTest {
        val file = TestDummy.PDF_DUMMY
        val bookmarkFile = TestDummy.BOOKMARK_DUMMY

        coEvery { toBookmark(file) } returns bookmarkFile
        coEvery { dao.insert(bookmarkFile) } just Runs

        repository.insert(file)

        coVerify { dao.insert(bookmarkFile) }
    }

    @Test
    fun `Given a unit when get is called then dao get is called`() = runTest {
        val bookmarkFiles = listOf(TestDummy.BOOKMARK_DUMMY)
        val files = listOf(TestDummy.PDF_DUMMY)

        coEvery { dao.get() } returns flowOf(bookmarkFiles)
        coEvery { toFileInfo(TestDummy.BOOKMARK_DUMMY) } returns TestDummy.PDF_DUMMY

        repository.get().testWithItem {
            assertEquals(files, this)
        }

        coVerify { dao.get() }
    }

    @Test
    fun `Given a file when delete is called then dao delete is called`() = runTest {
        val file = TestDummy.PDF_DUMMY
        val bookmarkFile = TestDummy.BOOKMARK_DUMMY

        coEvery { toBookmark(file) } returns bookmarkFile
        coEvery { dao.delete(bookmarkFile) } just Runs

        repository.delete(file)

        coVerify { dao.delete(bookmarkFile) }
    }
}
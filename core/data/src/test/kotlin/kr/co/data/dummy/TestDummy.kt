package kr.co.data.dummy

import kr.co.database.model.BookmarkFile
import kr.co.database.model.FileType
import kr.co.database.model.RecentFile
import kr.co.model.FileInfo
import java.time.LocalDateTime

internal object TestDummy {
    val PDF_DUMMY = FileInfo(
        name = "DUMMY.pdf",
        path = "",
        type = FileInfo.Type.PDF,
        isDirectory = false,
        isHidden = false,
        size = 0,
        createdAt = LocalDateTime.of(2024,6,2,2,0),
        lastModified = LocalDateTime.of(2024,6,2,2,0)
    )

    val RECENT_DUMMY = RecentFile(
        name = "DUMMY.pdf",
        path = "",
        type = FileType.PDF,
        size = 0,
        createdAt = LocalDateTime.of(2024,6,2,2,0),
        lastModified = LocalDateTime.of(2024,6,2,2,0)
    )

    val BOOKMARK_DUMMY = BookmarkFile(
        name = "DUMMY.pdf",
        path = "",
        type = FileType.PDF,
        size = 0,
        createdAt = LocalDateTime.of(2024,6,2,2,0),
        lastModified = LocalDateTime.of(2024,6,2,2,0)
    )
}
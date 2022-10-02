package com.metehanbolat.noteappkmm.data.note

import com.metehanbolat.noteappkmm.domain.note.Note
import database.NoteEntitiy
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun NoteEntitiy.toNote(): Note {
    return Note(
        id = id,
        title = title,
        content = content,
        colorHex = colorHex,
        created = Instant.fromEpochMilliseconds(created).toLocalDateTime(TimeZone.currentSystemDefault())
    )
}
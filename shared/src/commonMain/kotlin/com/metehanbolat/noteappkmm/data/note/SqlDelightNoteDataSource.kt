package com.metehanbolat.noteappkmm.data.note

import com.metehanbolat.noteappkmm.database.NoteDatabase
import com.metehanbolat.noteappkmm.domain.note.Note
import com.metehanbolat.noteappkmm.domain.note.NoteDataSource
import com.metehanbolat.noteappkmm.domain.time.DateTimeUtil

class SqlDelightNoteDataSource(db: NoteDatabase): NoteDataSource {

    private val queries = db.noteQueries

    override suspend fun insertNote(note: Note) {
        note.apply {
            queries.insertNote(
                id = id,
                title = title,
                content = content,
                colorHex = colorHex,
                created = DateTimeUtil.toEpochMillis(created)
            )
        }
    }

    override suspend fun getNoteById(id: Long): Note? {
        return queries
            .getNoteById(id)
            .executeAsOneOrNull()
            ?.toNote()
    }

    override suspend fun getAllNotes(): List<Note> {
        return queries
            .getAllNotes()
            .executeAsList()
            .map { it.toNote() }
    }

    override suspend fun deleteNoteById(id: Long) {
        queries.deleteNoteById(id)
    }
}
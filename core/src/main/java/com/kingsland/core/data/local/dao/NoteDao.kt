package com.kingsland.core.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.kingsland.core.data.local.dto.Note

@Dao
interface NoteDao {
    @Query("select * from Note")
    fun getAllNotes(): List<Note>

    @Query("select * from Note where projectId == (:projectId)")
    fun getAllNotesByProject(projectId: Int): List<Note>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note: Note)

    @Update
    fun updateNote(note: Note)

    @Delete
    fun deleteNote(note: Note)

}
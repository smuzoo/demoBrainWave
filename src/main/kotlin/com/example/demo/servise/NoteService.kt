package com.example.demo.service

import com.example.demo.model.Note
import org.springframework.stereotype.Service

@Service
class NoteService {

    // Простая имитация базы данных в памяти
    private val notes = mutableListOf<Note>()

    fun getAllNotes(): List<Note> {
        return notes
    }

    fun getNoteById(id: Long): Note? {
        return notes.find { it.id == id }
    }

    fun createNote(note: Note): Note {
        val newNote = note.copy(id = generateNewId())
        notes.add(newNote)
        return newNote
    }

    fun updateNote(id: Long, updatedNote: Note): Note? {
        val existingNote = notes.find { it.id == id }
        return if (existingNote != null) {
            val updated = existingNote.copy(title = updatedNote.title, content = updatedNote.content)
            notes.replaceAll { if (it.id == id) updated else it }
            updated
        } else {
            null
        }
    }

    fun deleteNote(id: Long): Boolean {
        val removedNote = notes.removeIf { it.id == id }
        return removedNote
    }

    // Вспомогательная функция для генерации нового уникального идентификатора заметки
    private fun generateNewId(): Long {
        return notes.maxOfOrNull { it.id }?.plus(1) ?: 1
    }
}

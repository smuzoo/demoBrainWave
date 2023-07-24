package com.example.demo.controller

import com.example.demo.model.Note
import com.example.demo.service.NoteService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/notes")
class NoteController(private val noteService: NoteService) {

    @GetMapping
    fun getAllNotes(): ResponseEntity<List<Note>> {
        val notes = noteService.getAllNotes()
        return ResponseEntity.ok(notes)
    }

    @GetMapping("/{id}")
    fun getNoteById(@PathVariable id: Long): ResponseEntity<Note> {
        val note = noteService.getNoteById(id)
        return if (note != null) {
            ResponseEntity.ok(note)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun createNote(@RequestBody note: Note): ResponseEntity<Note> {
        val createdNote = noteService.createNote(note)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNote)
    }

    @PutMapping("/{id}")
    fun updateNote(@PathVariable id: Long, @RequestBody note: Note): ResponseEntity<Note> {
        val updatedNote = noteService.updateNote(id, note)
        return if (updatedNote != null) {
            ResponseEntity.ok(updatedNote)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteNote(@PathVariable id: Long): ResponseEntity<Unit> {
        val isDeleted = noteService.deleteNote(id)
        return if (isDeleted) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}

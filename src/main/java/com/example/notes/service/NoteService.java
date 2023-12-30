package com.example.notes.service;

import com.example.notes.entity.Note;
import com.example.notes.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    public Note save(Note note) {
        return noteRepository.save(note);
    }

    public Note getById(long id) {
        return noteRepository.getReferenceById(id);
    }

    public boolean exists(long id) {
        return noteRepository.existsById(id);
    }

    public void deleteById(long id) {
        noteRepository.deleteById(id);
    }
}

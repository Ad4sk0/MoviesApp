package com.movies.service;

import com.movies.model.Note;
import com.movies.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> get() {
        return noteRepository.findAll();
    }

    public Optional<Note> get(Long id) {
        return noteRepository.findById(id);
    }
}

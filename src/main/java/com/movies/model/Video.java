package com.movies.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String path;
    @Transient
    private float rating;
    @OneToMany(mappedBy = "video")
    private List<Note> notes = new ArrayList<>();

    public Video() {};
    public Video(String title, String path) {
        this.title = title;
        this.path = path;
    }

    public void addNote(Note note) {
        this.notes.add(note);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public float getRating() {
        if (notes.size() == 0) return 0;
        float sum = 0f;
        for (Note note : notes) {
            sum += note.getNote();
        }
        return sum / notes.size();
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}

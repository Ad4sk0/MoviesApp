package com.movies.model;

import com.sun.istack.NotNull;
import javax.persistence.*;

@Table
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @NotNull
    private float note;
    @ManyToOne
    @NotNull
    private Video video;

    public Note() {};
    public Note(float note, Video video) {
        setNote(note);
        setVideo(video);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        if (note > 10 || note < 0) throw new IllegalArgumentException("Note should be in range from 0 to 10");
        this.note = note;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }
}

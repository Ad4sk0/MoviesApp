package com.movies.config;

import com.movies.model.Note;
import com.movies.model.Video;
import com.movies.repository.NoteRepository;
import com.movies.repository.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;


@Configuration
public class Config {

    @Bean
    CommandLineRunner commandLineRunner(
            VideoRepository videoRepository,
            NoteRepository noteRepository

    ) {
        return args -> {
            Video movie1  = new Video("Movie 1", "movie1.mp4");
            Video movie2  = new Video("Movie 2", "movie2.mp4");
            Video movie3  = new Video("Movie 3", "movie3.mp4");
            Video movie4  = new Video("Movie 4", "movie4.mp4");

            Note n1 = new Note(5, movie1);
            Note n2 = new Note(8, movie1);
            Note n3 = new Note(9, movie1);
            Note n4 = new Note(9, movie2);
            Note n5 = new Note(7, movie2);
            Note n6 = new Note(7, movie3);
            Note n7 = new Note(10, movie3);

            videoRepository.saveAll(List.of(movie1, movie2, movie3, movie4));
            noteRepository.saveAll(List.of(n1, n2, n3, n4, n5, n6, n7));
        };
    }
}
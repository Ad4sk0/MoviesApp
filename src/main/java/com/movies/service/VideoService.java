package com.movies.service;

import com.movies.model.Video;
import com.movies.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService {

    @Autowired
    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public List<Video> get() {
        return videoRepository.findAll();
    }

    public Optional<Video> get(Long id) {
        return videoRepository.findById(id);
    }
}

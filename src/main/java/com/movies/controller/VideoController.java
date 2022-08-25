package com.movies.controller;

import com.movies.model.Video;
import com.movies.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.io.*;
import java.util.Optional;

@Controller
public class VideoController {
    @Autowired
    VideoService videoService;

    @GetMapping("/video/{id}")
    public ResponseEntity<byte[]> getVideo(@PathVariable Long id) {

        Optional<Video> OptionalVideo = videoService.get(id);
        if (OptionalVideo.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Video video = OptionalVideo.get();
        byte[] data;

        try {
            InputStream resource = new ClassPathResource(String.format("media/%s", video.getPath())).getInputStream();
            data = resource.readAllBytes();
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept-Ranges", "bytes");
        headers.set("Content-Type", "video/mp4");
        headers.set("Content-Range", "bytes 50 - 300");
        headers.set("Content-Length", String.valueOf(data.length));

        return new ResponseEntity<byte[]>(data, headers, HttpStatus.OK);
    }
}

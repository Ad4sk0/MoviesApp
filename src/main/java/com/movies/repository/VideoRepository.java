package com.movies.repository;

import com.movies.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository <Video, Long> {

}

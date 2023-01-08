package com.friendsofgroot.app.repositories;

import com.friendsofgroot.app.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesRepository extends JpaRepository<Movie, Long> {
}

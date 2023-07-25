package org.example.service;

import java.util.List;
import org.example.model.Movie;

public interface MovieService {
    Movie add(Movie movie);

    Movie get(Long id);

    List<Movie> getAll();
}

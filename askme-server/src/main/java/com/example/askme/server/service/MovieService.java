package com.example.askme.server.service;

import com.example.askme.server.dto.MovieDto;
import com.example.askme.server.entity.Movie;

public interface MovieService {

    MovieDto addMovie (MovieDto movieDto);

    Movie updateMovie(MovieDto movieDto);

    Movie getMovieById(Long id);

    void deleteMovie(Long id);
}

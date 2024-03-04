package com.example.askme.server.service.impl;

import com.example.askme.server.Util.MovieMapper;
import com.example.askme.server.dto.MovieDto;
import com.example.askme.server.entity.Movie;
import com.example.askme.server.exception.ResourceNotFoundException;
import com.example.askme.server.repository.MovieRepo;
import com.example.askme.server.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private MovieRepo movieRepo;
    @Override
    public MovieDto addMovie(MovieDto movieDto) {
        Movie movie = MovieMapper.mapToMovieEntity(movieDto);
        Movie persistedMovie = movieRepo.save(movie);
        return MovieMapper.mapToMovieDto(persistedMovie);
    }

    @Override
    public Movie updateMovie(MovieDto movieDto) {
        Movie movie = movieRepo.findById(movieDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found for given id : "+movieDto.getId()));
        movie.setGenre(movieDto.getGenre());
        movie.setInfo(movieDto.getInfo());
        movie.setName(movieDto.getName());
        movie.setYear(movieDto.getYear());
        return movieRepo.save(movie);
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Movie not found for the given id : "+id));
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepo.deleteById(id);
    }
}

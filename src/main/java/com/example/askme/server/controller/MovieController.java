package com.example.askme.server.controller;

import com.example.askme.server.dto.MovieDto;
import com.example.askme.server.entity.Movie;
import com.example.askme.server.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@AllArgsConstructor
@RestController
@RequestMapping("/api/movie")
public class MovieController {

    private MovieService movieService;

    @PostMapping("/add")
    public ResponseEntity<MovieDto> addMovie(@RequestBody MovieDto movieDto){
        MovieDto persistedMovie = movieService.addMovie(movieDto);
        return new ResponseEntity<>(persistedMovie, HttpStatus.CREATED);
    }

    /*can use both RequestParam & PathVariable
    * RequestParam - extracts data from query params, key-value pair appended to url after "?" e.g.,http://localhost:8080/api/movie/get?id=1
    * PathVariable - extracts data from url path, param value is passed as is to method, e.g.,  @GetMapping("/get/{id}") url ->  http://localhost:8080/api/movie/get/1 */
    @GetMapping("/get")
    public ResponseEntity<Movie> getMovie(@RequestParam Long id){
        Movie movie = movieService.getMovieById(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Movie> updateMovie(@RequestBody MovieDto movieDto,
                                                @PathVariable Long id){
        Movie movie = movieService.updateMovie(movieDto);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @DeleteMapping("/movie")
    public String deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
        return "Movie Deleted";
    }
}

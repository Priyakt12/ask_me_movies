package com.example.askme.server.Util;

import com.example.askme.server.dto.MovieDto;
import com.example.askme.server.entity.Movie;

public class MovieMapper {

    public static MovieDto mapToMovieDto(Movie movie){
        return new MovieDto(
            movie.getId(), movie.getName(), movie.getGenre(), movie.getInfo(), movie.getYear()
        );
    }

    public static Movie mapToMovieEntity(MovieDto movieDto){
        return new Movie(
                movieDto.getId(), movieDto.getName(), movieDto.getGenre(), movieDto.getInfo(), movieDto.getYear()
        );
    }
}

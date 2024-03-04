package com.example.askme.server.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieDto {

    private Long id;
    private String name;
    private String genre;
    private String info;
    private String year;
    //private Double imdbRate;
}

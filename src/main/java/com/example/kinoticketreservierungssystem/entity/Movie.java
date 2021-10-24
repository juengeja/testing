package com.example.kinoticketreservierungssystem.entity;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import com.google.gson.Gson;
import org.springframework.data.annotation.Id;
import java.util.List;

@Container(containerName = "Movies")
public class Movie {
    @Id
    private String movieId;
    private String movieName;
    //Genre naming convention: Action, Thriller, Drama, Comedy...
    @PartitionKey
    private String mainGenre;
    private List<String> genres;
    private int duration;
    private String img;
    private String description;

    public Movie(String movieId, String movieName, String mainGenre, int duration, String img, String description) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.mainGenre = mainGenre;
        this.duration = duration;
        this.img = img;
        this.description = description;
    }

    public Movie() {

    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this, Movie.class);
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMainGenre() {
        return mainGenre;
    }

    public void setMainGenre(String mainGenre) {
        this.mainGenre = mainGenre;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}



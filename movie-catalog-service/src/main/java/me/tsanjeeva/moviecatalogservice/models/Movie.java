package me.tsanjeeva.moviecatalogservice.models;

public class Movie {
    private String movieId;
    private String name;
    private String description;
    private String tagline;

    public Movie() {

    }

    public Movie(String movieId, String name, String description, String tagline) {
        this.movieId = movieId;
        this.name = name;
        this.description = description;
        this.tagline = tagline;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }
}

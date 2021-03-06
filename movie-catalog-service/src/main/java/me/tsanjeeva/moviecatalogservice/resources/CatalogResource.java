package me.tsanjeeva.moviecatalogservice.resources;

import me.tsanjeeva.moviecatalogservice.models.CatalogItem;
import me.tsanjeeva.moviecatalogservice.models.Movie;
import me.tsanjeeva.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        UserRating userRating = restTemplate.getForObject("http://ratings-data-service/ratingsdata/user/" + userId, UserRating.class);

        return userRating.getRatings().stream()
                .map(rating -> {
                    String url = "http://movie-info-service/movies/" + rating.getMovieId();
                    Movie movie = restTemplate.getForObject(url, Movie.class);
                    return new CatalogItem(movie.getName(), movie.getDescription(), movie.getTagline(), rating.getRating());
                })
                .collect(Collectors.toList());
    }
}

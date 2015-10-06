package services;


import com.avaje.ebean.Model;
import models.Movie;

import java.util.List;

public class MovieService {

    public static final Model.Finder<Long, Movie> find = new Model.Finder<Long, Movie>(Long.class, Movie.class);

    public Movie findMovieById(Long id) {
        return find
                .where()
                .idEq(id)
                .findUnique();
    }

    public Movie createNewMovie(String name, String thumbnailHref) {
        Movie movie = new Movie();
        movie.name = name;
        movie.thumbnailHref = thumbnailHref;

        movie.save();

        return movie;
    }

    public List<Movie> getMoviesByFavList(Long favListId) {
        return find
                .where()
                .eq("favouritesLists.id", favListId)
                .findList();
    }

}

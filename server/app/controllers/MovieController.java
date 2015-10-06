package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Movie;
import play.libs.F;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.TheMovieDbService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class MovieController extends Controller {

    @Inject
    public TheMovieDbService service;

    public  Result getMovies() {
        return play.mvc.Results.TODO;
    }

    public  Result getMovie(long id) {
        return play.mvc.Results.TODO;
    }

    public  Result createNewMovie() {
        return play.mvc.Results.TODO;
    }

    public  Result updateMovie(long id) {
        return play.mvc.Results.TODO;
    }

    public  Result patchMovie(long id) {
        return play.mvc.Results.TODO;
    }

    public  Result deleteMovie(long id) {
        return play.mvc.Results.TODO;
    }

    public F.Promise<Result> search() {
        return service.searchMovies(request().getQueryString("query"))
                .map(result -> ok(result));
    }

}

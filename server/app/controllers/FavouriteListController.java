package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.FavouritesList;
import models.Movie;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.FavouritesListService;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;


public class FavouriteListController extends Controller {

    @Inject
    public FavouritesListService service;

    public  Result getFavouritesLists() {
        String username = session().get("username");
        List<FavouritesList> favouriteLists = service.getFavListsByUser(username);
        return ok(Json.toJson(favouriteLists));
    }

    public  Result getFavouritesList(long id) {
        return play.mvc.Results.TODO;
    }

    public Result createNewFavouritesList() {
        JsonNode jsonNode = request().body().asJson();
        if (jsonNode == null) {
            return badRequest("Expecting JSON data");
        }
        String name = jsonNode.findPath("name").textValue();
        boolean isDefault = jsonNode.findPath("isDefault").booleanValue();
        String username = session().get("username");

        if (username == null) {
            return forbidden("You are not logged in");
        } else if (name == null) {
            return badRequest("List name is needed to be specified");
        }

        FavouritesList list = service.createNewFavList(name, isDefault, username);



        return ok(Json.toJson(list));
    }

    public  Result updateFavouriteList(long id) {
        return play.mvc.Results.TODO;
    }

    public  Result patchFavouriteList(long id) {
        return play.mvc.Results.TODO;
    }

    public  Result deleteFavouriteList(long id) {
        return play.mvc.Results.TODO;
    }

    public  Result addMovieToFavouriteList(long listId) {
        JsonNode json = request().body().asJson();
        JsonNode movieJson = json.findPath("movie");

        Movie movie = new Movie();
        movie.name = movieJson.findPath("name").asText();
        movie.setThumbnailHref(movieJson.findPath("thumbnailHref").asText());
        movie.overview = movieJson.findPath("overview").asText();

        FavouritesList favouritesList = service.addMovieToFavList(listId, movie);

        return ok(Json.toJson(favouritesList));
    }

    public  Result removeMovieFromFavouriteList(long listId, long movieId) {
        return play.mvc.Results.TODO;
    }

    public Result getAllMoviesFromFavList(long listId) {
        List<Movie> movies = service.getAllMoviesFromFavList(listId);
        return ok(Json.toJson(movies));
    }


}

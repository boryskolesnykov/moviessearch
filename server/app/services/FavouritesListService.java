package services;


import com.avaje.ebean.Model;
import models.FavouritesList;
import models.Movie;
import models.User;

import javax.inject.Inject;
import java.util.List;

public class FavouritesListService {

    public static final Model.Finder<Long, FavouritesList> find = new Model.Finder<Long, FavouritesList>(Long.class, FavouritesList.class);

    @Inject
    public MovieService movieService;

    public FavouritesList getFavListById(Long id) {
        return find
                .where()
                .idEq(id)
                .findUnique();
    }

    public FavouritesList getFavListByName(String name) {
        return find
                .where()
                .eq("name", name)
                .findUnique();
    }

    public FavouritesList getDefaultFavList() {
        return find
                .where()
                .eq("isDefault", true)
                .findUnique();
    }

    public List<FavouritesList> getFavListsByUser(String username) {
        return find
                .where()
                .eq("user.email", username)
                .findList();
    }

    public FavouritesList createNewFavList(String name, boolean isDefault, String username) {

        if (isDefault) {
            FavouritesList defaultFavList = getDefaultFavList();
            if (defaultFavList != null) {
                defaultFavList.isDefault = false;
                defaultFavList.save();
            }
        }

        FavouritesList list = new FavouritesList();
        list.name = name;
        list.user = User.findByEmail(username);
        list.isDefault = isDefault;

        list.save();

        return list;
    }

    public FavouritesList addMovieToFavList(Long favListId, Movie movie) {

        movie.save();

        FavouritesList list = getFavListById(favListId);
        list.movies.add(movie);

        list.save();

        return list;
    }

    public List<Movie> getAllMoviesFromFavList(long favListId) {
        FavouritesList list = getFavListById(favListId);
        return list.movies;
    }
}

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

    public List<FavouritesList> getFavListsByUser(String username) {
        return find
                .where()
                .eq("user.name", username)
                .findList();
    }

    public FavouritesList createNewFavList(String name, String username) {
        FavouritesList list = new FavouritesList();
        list.name = name;
        list.user = User.findByEmail(username);

        list.save();

        return list;
    }

    public FavouritesList addMovieToFavList(Long favListId, Long movieId) {
        FavouritesList list = getFavListById(favListId);
        Movie movie = movieService.findMovieById(movieId);

        list.movies.add(movie);

        list.save();

        return list;
    }
}

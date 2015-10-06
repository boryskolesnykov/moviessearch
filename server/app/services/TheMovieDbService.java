package services;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.F;
import play.libs.ws.WSClient;

import javax.inject.Inject;

public class TheMovieDbService {

    public static final String API_KEY_PARAM = "api_key";
    public static final String API_KEY = "7a4de0fe5da237bdb52d1168dae8cd14";
    public static final String BASE_URL = "http://api.themoviedb.org/3";
    public static final String SEARCH_URL = BASE_URL + "/search/movie";

    @Inject
    public WSClient wsClient;

    public F.Promise<JsonNode> searchMovies(String query) {
        return wsClient.url(SEARCH_URL)
                .setQueryParameter(API_KEY_PARAM, API_KEY)
                .setQueryParameter("query", query)
                .get().map(wsResponse -> wsResponse.asJson());
    }

}

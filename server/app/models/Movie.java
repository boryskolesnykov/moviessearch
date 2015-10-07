package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.Set;

@Entity
public class Movie extends Model {

    public static final String BASIC_THUMBNAIL_URL = "http://image.tmdb.org/t/p/w300";
    public static final String API_KEY_SUFFIX = "?api_key=7a4de0fe5da237bdb52d1168dae8cd14";

    @Id
    public Long id;

    @Column(nullable = false, unique = true)
    @Constraints.Required
    public String name;

    @Column(name = "thumbnail")
    @Constraints.Required
    public String thumbnailHref;

    @Column(length = 65535)
    @Constraints.Required
    public String overview;

    @ManyToMany
    public List<FavouritesList> favouritesLists;

    public void setThumbnailHref(String path) {
        this.thumbnailHref = BASIC_THUMBNAIL_URL + path + API_KEY_SUFFIX;
    }

}

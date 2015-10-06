package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Movie extends Model {

    @Id
    public Long id;

    @Column(nullable = false, unique = true)
    @Constraints.Required
    public String name;

    @Column(name = "thumbnail")
    @Constraints.Required
    public String thumbnailHref;

    @ManyToMany
    public Set<FavouritesList> favouritesLists;

}

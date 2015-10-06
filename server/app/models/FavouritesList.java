package models;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.Set;

@Entity
public class FavouritesList extends Model {

    @Id
    public Long id;

    @Constraints.Required
    public String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    public User user;

    @ManyToMany
    public Set<Movie> movies;

    @Column(name = "default")
    @Constraints.Required
    public Boolean isDefault;

}

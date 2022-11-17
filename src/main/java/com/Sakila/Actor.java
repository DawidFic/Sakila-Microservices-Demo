package com.Sakila;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Actor")

public class Actor {
    //Attributes//

    @Id
    @Column(name = "actor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int actorID;

    @Column(name = "first_name")
    String actorFirstName;

    @Column(name = "last_name")
    String actorLastName;

    @ManyToMany(mappedBy = "filmActor")
    Set<Film> actorFilm;

    //Constructors//
    public Actor(String firstName, String lastName) {
        this.actorFirstName = firstName;
        this.actorLastName = lastName;
    }

    public Actor() {
    }

    //Methods//
    public int getActorID() {
        return actorID;
    }

    public void setActorID(int actorID) {
        this.actorID = actorID;
    }

    public String getActorFirstName() {
        return actorFirstName;
    }

    public void setActorFirstName(String actorFirstName) {
        this.actorFirstName = actorFirstName;
    }

    public String getActorLastName() {
        return actorLastName;
    }

    public void setActorLastName(String actorLastName) {
        this.actorLastName = actorLastName;
    }
}

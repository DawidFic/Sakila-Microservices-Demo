import antlr.collections.List;
import com.Sakila_Microservices.ActorInterface;
import com.Sakila_Microservices.FilmInterface;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.ScenarioScope;
import org.junit.jupiter.api.Assertions;
import com.Sakila_Microservices.SakilaMicroservicesDemoApplication;
import com.Sakila_Microservices.Film;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@ScenarioScope
public class movieDetailsFeatureStepDef {
    @Autowired
    FilmInterface filmInterface;
    @Autowired
    ActorInterface actorInterface;
    @Autowired
    SakilaMicroservicesDemoApplication sakilaMicroservicesDemoApplication = new SakilaMicroservicesDemoApplication(actorInterface, filmInterface);
    Optional<Film> movie;
    String title;
    @Given("a users favourite movie")
    public void a_users_favourite_movie() {
        title = "ACE GOLDFINGER";
    }
    @When("the user searches for the movie")
    public void the_user_searches_for_the_movie() {
        // Write code here that turns the phrase above into concrete actions
        movie = filmInterface.findByTitle(title);
    }
    @Then("the program returns the movie details")
    public void the_program_returns_the_movie_details() {
        // Write code here that turns the phrase above into concrete actions
        Assertions.assertEquals(2, movie.get().getFilmID(), "WRONG FILM ID FOUND");
        Assertions.assertEquals("ACE GOLDFINGER", movie.get().getFilmTitle(), "WRONG FILM TITLE FOUND");
        Assertions.assertEquals("A Astounding Epistle of a Database Administrator And a Explorer who must Find a Car in Ancient China", movie.get().getFilmDescription(), "WRONG FILM DESCRIPTION FOUND");
        Assertions.assertEquals("2006-01-01", movie.get().getFilmReleaseYear(), "WRONG FILM RELEASE YEAR FOUND");
        Assertions.assertEquals('1', movie.get().getFilmLanguageID(), "WRONG FILM LANGUAGE ID FOUND");
        Assertions.assertEquals(48, movie.get().getFilmLength(), "WRONG FILM LENGTH FOUND");
        Assertions.assertEquals("G", movie.get().getFilmRating(), "WRONG FILM RATING FOUND");
    }
}

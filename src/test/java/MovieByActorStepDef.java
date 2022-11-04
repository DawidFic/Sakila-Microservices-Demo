import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MovieByActorStepDef {

    String actorFirstName;
    String actorLastName;

    @Given("a user specified actor name")
    public void a_user_specified_actor_name() {
        // Write code here that turns the phrase above into concrete actions
        actorFirstName = "PENELOPE";
        actorLastName = "GUINESS";
    }
    @When("the user searches for the movies which feature an actor")
    public void the_user_searches_for_the_movies_which_feature_an_actor() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the program returns the appropriate movie titles")
    public void the_program_returns_the_appropriate_movie_titles() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}

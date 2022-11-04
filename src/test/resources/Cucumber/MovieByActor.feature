Feature: This feature will search for movie titles which feature a specified actor.
  As a user, I would like to be able to see the list of movies which feature a specific actor

  Scenario: Successfully displaying the titles of a movie which feature a specific actor
    Given a user specified actor name
    When the user searches for the movies which feature an actor
    Then the program returns the appropriate movie titles
Feature: This feature will search for movie details.
  As a user, I would like to be able to select a movie so that I can have the details of the movie displayed

  Scenario: Successfully displaying the details of a movie
    Given a users favourite movie
    When the user searches for the movie
    Then the program returns the movie details
package com.Sakila_Microservices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ActorTest {

    Actor actor = new Actor("Tester", "Testing");

    @Test
    public void testFirstName(){
        Assertions.assertEquals("Tester", actor.getActorFirstName(), "ACTOR FIRST NAME HAS NOT BEEN RETURNED CORRECTLY");
        actor.setActorFirstName("Testee");
        Assertions.assertEquals("Testee", actor.getActorFirstName(), "ACTOR FIRST NAME HAS NOT BEEN CHANGED");
    }

    @Test
    public void testLastName(){
        Assertions.assertEquals("Testing", actor.getActorLastName(), "ACTOR LAST NAME HAS NOT BEEN RETURNED CORRECTLY");
        actor.setActorLastName("Testee");
        Assertions.assertEquals("Testee", actor.getActorLastName(), "ACTOR LAST NAME HAS NOT BEEN CHANGED");
    }
}

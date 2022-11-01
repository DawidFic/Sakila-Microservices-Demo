package com.Sakila_Microservices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ActorTest {

    Actor actor = new Actor("Tester", "Testing");

    @Test
    public void testConstructor(){
        new Actor();
    }

    @Test
    public void testGetFirstName(){
        Assertions.assertEquals("Tester", actor.getActorFirstName(), "ACTOR FIRST NAME HAS NOT BEEN RETURNED CORRECTLY");
    }

    @Test
    public void testSetFirstName(){
        actor.setActorFirstName("Testee");
        Assertions.assertEquals("Testee", actor.getActorFirstName(), "ACTOR FIRST NAME HAS NOT BEEN CHANGED");
    }

    @Test
    public void testLastName(){
        Assertions.assertEquals("Testing", actor.getActorLastName(), "ACTOR LAST NAME HAS NOT BEEN RETURNED CORRECTLY");
    }

    @Test
    public void testSetLastName(){
        actor.setActorLastName("Testee");
        Assertions.assertEquals("Testee", actor.getActorLastName(), "ACTOR LAST NAME HAS NOT BEEN CHANGED");
    }

    @Test
    public void testGetID(){
        int tempActorID = actor.getActorID();
        Assertions.assertEquals(0, tempActorID, "FAILED GET ACTOR ID");
    }

    @Test
    public void testSetID(){
        actor.setActorID(1);
        Assertions.assertEquals(1, actor.getActorID(), "FAILED SET ACTOR ID");
    }
}

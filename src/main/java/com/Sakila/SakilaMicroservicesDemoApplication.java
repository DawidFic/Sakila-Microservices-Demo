package com.Sakila;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.*;

@SpringBootApplication
@RestController
@RequestMapping("/api")
@CrossOrigin
public class SakilaMicroservicesDemoApplication {

	@Autowired
	private ActorInterface actorInterface;
	@Autowired
	private FilmInterface filmInterface;

	public SakilaMicroservicesDemoApplication(ActorInterface actorInterface, FilmInterface filmInterface) {
		this.actorInterface = actorInterface;
		this.filmInterface = filmInterface;
	}

	public static void main(String[] args) {
		SpringApplication.run(SakilaMicroservicesDemoApplication.class, args);

	}

	@GetMapping("/allActors")
	public @ResponseBody
	Iterable<Actor> getAllActors() {
		return actorInterface.findAll();
	}

	@GetMapping("/actorByName/{fname}/{lname}") //not working
	public List<Actor> getActorByName(@PathVariable(value = "fname") String fname, @PathVariable(value = "lname") String lname) {
		return actorInterface.findByNames(fname, lname);
	}

	@GetMapping("/actorById/{id}")
	public Actor getSingleActor(@PathVariable(value = "id") int actorID) {
		return actorInterface.findById(actorID).orElseThrow(() -> new ResourceAccessException("Actor not found with ID " + actorID));
	}

	@PutMapping("/updateActor/{id}") //working
	public ResponseEntity<Actor> updateActor(@PathVariable(value = "id") Integer actorID, @Validated @RequestBody Actor actorDetails) throws ResourceAccessException {
		Actor actor = actorInterface.findById(actorID).orElseThrow(() -> new ResourceAccessException("Actor not found with ID: " + actorID));
		actor.setActorID(actor.getActorID());
		actor.setActorFirstName(actorDetails.getActorFirstName());
		actor.setActorLastName(actorDetails.getActorLastName());

		final Actor updatedActor = actorInterface.save(actor);
		return ResponseEntity.ok(updatedActor);
	}

	@DeleteMapping("/delActor/{id}") //working
	public Map<String, Boolean> deleteActor(@PathVariable(value = "id") Integer actorID) throws ResourceAccessException {
		Actor actor = actorInterface.findById(actorID).orElseThrow(() -> new ResourceAccessException("Actor not found with ID: " + actorID));

		actorInterface.delete(actor);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@PostMapping("/createActor")
	public Actor createActor(@Validated @RequestBody Actor actor) {
		return actorInterface.save(actor);
	}

	@PostMapping("/newActor")
	public ResponseEntity<Actor> saveActor(@RequestBody Actor actorDetails) {
		try {
			return new ResponseEntity<>(actorInterface.save(actorDetails), HttpStatus.CREATED);
		}
		catch (Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/allFilms")
	public @ResponseBody
	Iterable<Film> getAllFilms() {
		return filmInterface.findAll();
	}

	@GetMapping("/allFilms/{title}")
	public @ResponseBody List<Film> getFilmByName(@PathVariable(value = "title") String filmTitle) {
		return filmInterface.findByTitle(filmTitle);
	}

	@GetMapping("/filmByActor/{firstname}")
	public @ResponseBody Set<Film> getFilmsByActor(@PathVariable(value = "firstname") String firstname) {
		return filmInterface.findFilmsByActor(firstname);
	}
}

package com.Sakila_Microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.*;

@SpringBootApplication
@RestController
@RequestMapping("/home")
@CrossOrigin
public class SakilaMicroservicesDemoApplication {

	@Autowired
	private ActorInterface actorInterface;
	@Autowired
	private FilmInterface filmInterface;

	@Autowired
	private CategoryInterface categoryInterface;

	public SakilaMicroservicesDemoApplication(ActorInterface actorInterface, FilmInterface filmInterface) {
		this.actorInterface = actorInterface;
		this.filmInterface = filmInterface;
	}

	public static void main(String[] args) {
		SpringApplication.run(SakilaMicroservicesDemoApplication.class, args);

	}

	@GetMapping("/Actors")
	public @ResponseBody
	Iterable<Actor> getAllActors() {
		return actorInterface.findAll();
	}

	@GetMapping("/Actors/{fname}/{lname}")
	public List<Actor> getActorByName(@PathVariable(value = "fname") String fname, @PathVariable(value = "lname") String lname) {
		return actorInterface.findByNames(fname, lname);
	}

	@GetMapping("/Actors/{id}")
	public Actor getSingleActor(@PathVariable(value = "id") int actorID) {
		return actorInterface.findById(actorID).orElseThrow(() -> new ResourceAccessException("Actor not found with ID " + actorID));
	}

	@PutMapping("/Actors/{id}")
	public ResponseEntity<Actor> updateActor(@PathVariable(value = "id") Integer actorID, @Validated @RequestBody Actor actorDetails) throws ResourceAccessException {
		Actor actor = actorInterface.findById(actorID).orElseThrow(() -> new ResourceAccessException("Actor not found with ID: " + actorID));
		actor.setActorID(actor.getActorID());
		actor.setActorFirstName(actorDetails.getActorFirstName());
		actor.setActorLastName(actorDetails.getActorLastName());

		final Actor updatedActor = actorInterface.save(actor);
		return ResponseEntity.ok(updatedActor);
	}

	@DeleteMapping("/Actors/{id}")
	public Map<String, Boolean> deleteActor(@PathVariable(value = "id") Integer actorID) throws ResourceAccessException {
		Actor actor = actorInterface.findById(actorID).orElseThrow(() -> new ResourceAccessException("Actor not found with ID: " + actorID));

		actorInterface.delete(actor);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@PostMapping("/Actors")
	public Actor createActor(@Validated @RequestBody Actor actor) {
		return actorInterface.save(actor);
	}

	@GetMapping("/allFilms")
	public @ResponseBody
	Iterable<Film> getAllFilms() {
		return filmInterface.findAll();
	}

	@GetMapping("/allFilms/{title}")
	public @ResponseBody Optional<Film> getFilmByName(@PathVariable(value = "title") String filmTitle) {
		return filmInterface.findByTitle(filmTitle);
	}

	@GetMapping("/allFilms/{firstname}")
	public @ResponseBody List<Film> getFilmsByActor(@PathVariable(value = "firstname") String firstname) {
		return filmInterface.findFilmsByActor(firstname);
	}

	@GetMapping("/CategoryByFilmID/{id}")
	@ResponseBody
	public Optional<Category> getCategoryByFilmID(@PathVariable Integer id){return categoryInterface.findById(id);}
}

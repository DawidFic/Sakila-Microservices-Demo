package com.Sakila_Microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.HashMap;
import java.util.Map;

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
	private CityInterface cityInterface;
	@Autowired
	private CountryInterface countryInterface;
	@Autowired
	private LanguageInterface languageInterface;

	public SakilaMicroservicesDemoApplication(ActorInterface actorInterface, FilmInterface filmInterface, CityInterface cityInterface, CountryInterface countryInterface, LanguageInterface languageInterface) {
		this.actorInterface = actorInterface;
		this.filmInterface = filmInterface;
		this.cityInterface = cityInterface;
		this.countryInterface = countryInterface;
		this.languageInterface = languageInterface;
	}

	public static void main(String[] args) {
		SpringApplication.run(SakilaMicroservicesDemoApplication.class, args);

	}

	@GetMapping("/allActors")
	public @ResponseBody
	Iterable<Actor> getAllActors() {return actorInterface.findAll();}

	@PutMapping("/allActors/{id}")
	public ResponseEntity<Actor> updateActor(@PathVariable(value = "id") Integer actorID, @Validated @RequestBody Actor actorDetails) throws ResourceAccessException {
		Actor actor = actorInterface.findById(actorID).orElseThrow(() -> new ResourceAccessException("Actor not found with ID: " + actorID));
		actor.setActorID(actor.getActorID());
		actor.setActorFirstName(actorDetails.getActorFirstName());
		actor.setActorLastName(actorDetails.getActorLastName());

		final Actor updatedActor = actorInterface.save(actor);
		return ResponseEntity.ok(updatedActor);
	}

	@DeleteMapping("/allActors/{id}")
	public Map<String, Boolean> deleteActor(@PathVariable(value = "id") Integer actorID) throws ResourceAccessException {
		Actor actor = actorInterface.findById(actorID).orElseThrow(() -> new ResourceAccessException("Actor not found with ID: " + actorID));

		actorInterface.delete(actor);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	@PostMapping("/allActors")
	public Actor createActor(@Validated @RequestBody Actor actor) {
		return actorInterface.save(actor);
	}

	@GetMapping("/allFilms")
	public @ResponseBody
	Iterable<Film> getAllFilms() {return filmInterface.findAll();}

	@GetMapping("/allCity")
	public @ResponseBody
	Iterable<City> getAllCity() {return cityInterface.findAll();}

	@GetMapping("/allCountry")
	public @ResponseBody
	Iterable<Country> getAllCountry() {return countryInterface.findAll();}

	@GetMapping("/allLanguage")
	public @ResponseBody
	Iterable<Language> getAllLanguage() {return languageInterface.findAll();}

}

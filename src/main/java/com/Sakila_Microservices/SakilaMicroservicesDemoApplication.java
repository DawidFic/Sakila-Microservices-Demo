package com.Sakila_Microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

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

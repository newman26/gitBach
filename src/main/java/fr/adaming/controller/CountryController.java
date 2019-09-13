package fr.adaming.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Country;

import fr.adaming.service.ICountryService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CountryController {

	@Autowired
	ICountryService countryService;

	@RequestMapping(value = "/countries", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Country> getCountries() {
		List<Country> listOfCountries = countryService.getAllCountries();
		return listOfCountries;
	}

	@RequestMapping(value = "/country", method = RequestMethod.GET, produces={"application/json"} )
	public Country getCountryById(@RequestParam("id") int id) {
		return countryService.getCountry(id);
	}

	@RequestMapping(value = "/countries", method = RequestMethod.POST, produces= "application/json", consumes="application/json")
	public Country addCountry(@RequestBody Country country) {
		return countryService.addCountry(country);
	}

	@RequestMapping(value = "/countries", method = RequestMethod.PUT, produces= "application/json",consumes="application/json")
	public Country updateCountry(@RequestBody Country country) {
		return countryService.updateCountry(country);

	}

	@RequestMapping(value = "/country/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteCountry(@PathVariable("id") int id) {
		countryService.deleteCountry(id);

	}

}

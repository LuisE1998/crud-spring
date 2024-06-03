package exampleSpring.crud.country;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import exampleSpring.crud.exception.NotFoundException;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    CountryServive countryServive;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CountryEntity> getCountries(){
        return countryServive.getCountries();
    }

    @GetMapping(value="/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<CountryEntity> getCountryById(@PathVariable("id") Long id){
        return countryServive.getCountryById(id);
    }

    @GetMapping(value="/country/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<CountryEntity> getCountryByName(@PathVariable("name") String name){
        return countryServive.getCountryByName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CountryEntity saveCountry(@RequestBody CountryEntity country){
        if(country.getName()==null)
            throw new NotFoundException("El país no puede ser nulo");
        return countryServive.saveCountry(country);
    }

    @PutMapping(value="/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CountryEntity saveCountry(@RequestBody CountryEntity country, @PathVariable Long id){
        Optional<CountryEntity> findCountryEntity = countryServive.getCountryById(id);
        if(!findCountryEntity.isPresent())
            throw new NotFoundException("El país no existe");    
        return countryServive.updateCountry(country, id);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<String> deleteCountry(@PathVariable Long id){
        countryServive.deleteCountry(id);
        return new ResponseEntity<>("Pais eliminado", HttpStatus.OK);
    }

}

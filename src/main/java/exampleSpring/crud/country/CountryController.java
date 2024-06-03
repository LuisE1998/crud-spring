package exampleSpring.crud.country;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    CountryServive countryServive;

    @GetMapping
    public List<CountryEntity> getCountries(){
        return countryServive.getCountries();
    }

    @GetMapping(value="/{id}")
    public Optional<CountryEntity> getCountryById(@PathVariable("id") Long id){
        return countryServive.getCountryById(id);
    }

    @PostMapping
    public CountryEntity saveCountry(@RequestBody CountryEntity country){
        try{            
            if(country==null)
                throw new IOException("El país no puede ser nulo");
        }catch(IOException e){
            System.out.println("Error: " + e);
        }        
        return countryServive.saveCountry(country);
    }

    @PutMapping(value="/{id}")
    public CountryEntity saveCountry(@RequestBody CountryEntity country, @PathVariable Long id){
        try{            
            if(country==null)
                throw new IOException("El país no puede ser nulo");
        }catch(IOException e){
            System.out.println("Error: " + e);
        }        
        return countryServive.updateCountry(country, id);
    }

    @DeleteMapping(value="/{id}")
    public boolean deleteCountry(@PathVariable Long id){
        return countryServive.deleteCountry(id);
    }

}

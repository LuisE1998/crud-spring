package exampleSpring.crud.country;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServive {

    @Autowired
    CountryRepository countryRepository;

    public List<CountryEntity> getCountries(){
        return countryRepository.findAll();
    }

    public Optional<CountryEntity> getCountryById(Long id){
        return countryRepository.findById(id);
    }

    public CountryEntity saveCountry(CountryEntity country){
        return countryRepository.save(country);
    }

    public CountryEntity updateCountry(CountryEntity request, Long id){
        CountryEntity country = countryRepository.findById(id).get();
        country.setName(request.getName());
        countryRepository.save(country);
        return country;
    }

    public boolean deleteCountry(Long id){
        try {
            countryRepository.deleteById(id);
            return true;
        }catch(Exception e) {
            return false;
        }        
    }
}

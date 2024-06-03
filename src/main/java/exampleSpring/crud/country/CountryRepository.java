package exampleSpring.crud.country;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<CountryEntity, Long>{

    public Optional<CountryEntity> findByName(String name);

}

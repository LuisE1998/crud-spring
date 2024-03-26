package exampleSpring.crud.autors;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

    @Autowired
    AutorRepository autorRepository;

    public List<AutorEntity> getAutors(){
        return autorRepository.findAll();
    }

    public Optional<AutorEntity> getAutor(Long id){
        return autorRepository.findById(id);
    }

    public AutorEntity saveAutor(AutorEntity autor){
        return autorRepository.save(autor);
    }

    public AutorEntity updateAutor(AutorEntity request, Long id){
        AutorEntity autor = autorRepository.findById(id).get();
        autor.setName(request.getName());
        autorRepository.save(autor);
        return autor;
    }

    public boolean deteleAutor(Long id){
        try{
            autorRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

}

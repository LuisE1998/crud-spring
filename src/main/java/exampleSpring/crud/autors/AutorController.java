package exampleSpring.crud.autors;

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
@RequestMapping("/autors")
public class AutorController {

    @Autowired
    AutorService autorService;

    @GetMapping
    public List<AutorEntity> getUsers(){
        return autorService.getAutors();
    }

    @GetMapping(path = "/{id}")
    public Optional<AutorEntity> getAutor(@PathVariable Long id){
        return autorService.getAutor(id);
    }

    @PostMapping
    public AutorEntity saveAutor(@RequestBody AutorEntity autor){
        return autorService.saveAutor(autor);
    }

    @PutMapping(path = "/{id}")
    public AutorEntity updateAutor(@RequestBody AutorEntity request, @PathVariable Long id){
        return autorService.updateAutor(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteAutor(@PathVariable Long id){
        return autorService.deteleAutor(id);
    }
}

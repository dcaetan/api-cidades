package com.github.douglasctolima.apicidades.paises;

import com.github.douglasctolima.apicidades.paises.Pais;
import com.github.douglasctolima.apicidades.paises.repository.PaisRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/paises")
public class PaisResources {

    /*
    @Autowired //anotação spring para injeção de dependencia (repositorio, neste caso). mesmo objetivo do construtor abaixo
    private PaisRepository repository;
    */

    private PaisRepository repository;

    public PaisResources(PaisRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<Pais> paises(Pageable page) {
        return repository.findAll(page);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity getOne(@PathVariable Long id) {
        Optional<Pais> optional = repository.findById(id);

        if (optional.isPresent()) {
            return ResponseEntity.ok().body(optional.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}

package com.github.douglasctolima.apicidades.estados;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estados")
public class EstadoResource {
    private final EstadoRepository repository;

    public EstadoResource(final EstadoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Page<Estado> estados(final Pageable page) {
        return repository.findAll(page);
    }
}

package com.github.douglasctolima.apicidades.distancias;

import com.github.douglasctolima.apicidades.distancias.service.DistanciaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distancias")
public class DistanciaResource {
    private final DistanciaService service;
    Logger log = LoggerFactory.getLogger(DistanciaResource.class);

    public DistanciaResource(DistanciaService service) {
        this.service = service;
    }

    //Opção 1 - distacia em milhas.
    @GetMapping("/milhas")
    public ResponseEntity byPoints(@RequestParam(name = "from") final Long cidade1,
                                   @RequestParam(name = "to") final Long cidade2) {
        log.info("milhas");
        return ResponseEntity.ok().body(service.distanciaByPointsInMiles(cidade1, cidade2));
    }

    //Opção 2 - distacia em metros.
    @GetMapping("/metros")
    public ResponseEntity byCube(@RequestParam(name = "from") final Long cidade1,
                         @RequestParam(name = "to") final Long cidade2) {
        log.info("metros");
        return ResponseEntity.ok().body(service.distanciaByCubeInMeters(cidade1, cidade2));
    }
}

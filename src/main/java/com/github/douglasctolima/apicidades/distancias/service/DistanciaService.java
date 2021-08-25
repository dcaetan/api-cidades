package com.github.douglasctolima.apicidades.distancias.service;

import java.util.Arrays;
import java.util.List;

import com.github.douglasctolima.apicidades.cidades.Cidade;
import com.github.douglasctolima.apicidades.cidades.CidadeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

@Service
public class DistanciaService {
    Logger log = LoggerFactory.getLogger(DistanciaService.class);
    private final CidadeRepository cidadeRepository;

    public DistanciaService(final CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }

    //Opção 1 - distacia em milhas.
    public Double distanciaByPointsInMiles(final Long cidade1, final Long cidade2) {
        log.info("nativePostgresInMiles({}, {})", cidade1, cidade2);
        return cidadeRepository.distanciaByPoints(cidade1, cidade2);
    }

    //Opção 2 - distacia em metros.
    public Double distanciaByCubeInMeters(Long cidade1, Long cidade2) {
        log.info("distanceByCubeInMeters({}, {})", cidade1, cidade2);
        final List<Cidade> cidades = cidadeRepository.findAllById((Arrays.asList(cidade1, cidade2)));

        Point p1 = cidades.get(0).getLocation();
        Point p2 = cidades.get(1).getLocation();

        return cidadeRepository.distanciaByCube(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }
}

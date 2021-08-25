package com.github.douglasctolima.apicidades.cidades;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    String QUERY = "SELECT ((SELECT lat_lon FROM cidade WHERE id=?1) <@> "
            + "(SELECT lat_lon FROM cidade WHERE id=?2)) as distance";

    @Query(value = QUERY, nativeQuery = true)
    Double distanciaByPoints(final Long cidadeId1, final Long cidadeId2);

    @Query(value = "SELECT earth_distance(ll_to_earth(?1,?2), ll_to_earth(?3,?4)) as distance", nativeQuery = true)
    Double distanciaByCube(final Double lat1, final Double lon1, final Double lat2, final Double lon2);
}

package br.com.cinq.spring.data.sample.repository;

import java.util.List;

import br.com.cinq.spring.data.sample.entity.Country;

public interface CountryRepository extends GenericRepository<Country, Long> {

    /**
     * @param string
     * @return
     */
    List<Country> findLikeName(String string);
}

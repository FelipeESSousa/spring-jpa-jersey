package br.com.cinq.spring.data.sample.service;

import java.util.List;
import java.util.Optional;

import br.com.cinq.spring.data.sample.entity.City;
import br.com.cinq.spring.data.sample.entity.Country;

public interface CityService extends GenericService<City, Long> {

    /**
     * @param country
     * @return
     */
    Optional<List<City>> findByCountry(Country country);
}
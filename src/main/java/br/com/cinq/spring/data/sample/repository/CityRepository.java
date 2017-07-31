package br.com.cinq.spring.data.sample.repository;

import java.util.List;

import br.com.cinq.spring.data.sample.entity.City;
import br.com.cinq.spring.data.sample.entity.Country;

public interface CityRepository extends GenericRepository<City, Long>{

    /**
     * @param country
     * @return
     */
    List<City> findByCountry(Country country);

}

package br.com.cinq.spring.data.sample.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cinq.spring.data.sample.entity.City;
import br.com.cinq.spring.data.sample.entity.Country;
import br.com.cinq.spring.data.sample.repository.CityRepository;
import br.com.cinq.spring.data.sample.service.CityService;

@Service
@Transactional
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    
    @Override
    public Optional<List<City>> list(Integer page, Integer size, City entity) {
        return Optional.of(cityRepository.findAll(page, size, entity));
    }

    /* (non-Javadoc)
     * @see br.com.cinq.spring.data.sample.service.GenericService#create(java.lang.Object)
     */
    @Override
    public Optional<City> create(City entity) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see br.com.cinq.spring.data.sample.service.GenericService#findById(java.io.Serializable)
     */
    @Override
    public Optional<City> findById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see br.com.cinq.spring.data.sample.service.GenericService#update(java.io.Serializable, java.lang.Object)
     */
    @Override
    public Optional<City> update(Long id, City entity) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see br.com.cinq.spring.data.sample.service.GenericService#deleteById(java.io.Serializable)
     */
    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        
    }
    
    public Optional<List<City>> findByCountry(Country country) {
        return Optional.of(cityRepository.findByCountry(country));
    }

}
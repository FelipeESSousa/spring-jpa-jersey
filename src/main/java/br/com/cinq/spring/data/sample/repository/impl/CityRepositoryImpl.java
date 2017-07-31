package br.com.cinq.spring.data.sample.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.jdbc.StringUtils;

import br.com.cinq.spring.data.sample.entity.City;
import br.com.cinq.spring.data.sample.entity.Country;
import br.com.cinq.spring.data.sample.repository.AbstractRepository;
import br.com.cinq.spring.data.sample.repository.CityRepository;

@Transactional
@Repository
public class CityRepositoryImpl extends AbstractRepository<City, Long> implements CityRepository {

    @Autowired
    public CityRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<City> findByCountry(Country country) {
        Criteria cr = this.getSession().createCriteria(City.class);
        if (null != country){
            if(!StringUtils.isEmptyOrWhitespaceOnly(country.getName())) {
            cr.createAlias("country", "country");
            cr.add(Restrictions.ilike("country.name", country.getName(), MatchMode.START));
            }
            if(null != country.getId()){
                cr.add(Restrictions.eq("country.id", country.getId()));
            }
        }
        return cr.list();
    }

}
package br.com.cinq.spring.data.sample.resource;

import static org.springframework.http.HttpStatus.OK;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cinq.spring.data.sample.entity.City;
import br.com.cinq.spring.data.sample.entity.Country;
import br.com.cinq.spring.data.sample.service.CityService;

@RestController
@RequestMapping("rest/cities")
public class CityResource extends BaseResource {

    private final Logger LOGGER = Logger.getLogger(CityResource.class);

    @Autowired
    private CityService cityService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody ResponseEntity<?> list(
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "50") Integer size,
            @RequestParam(name = "country", required = false) String countryName) {

        LOGGER.info("GET /rest/cities");

        Country country = new Country();
        country.setName(countryName);

        City city = new City();
        city.setCountry(country);

        Optional<List<City>> optCity = this.cityService.findByCountry(country);

        checkNotNull(optCity, "Cities");

        return buildResponse(OK, optCity, page, size);
    }

}

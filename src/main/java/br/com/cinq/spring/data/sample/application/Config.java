package br.com.cinq.spring.data.sample.application;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import br.com.cinq.spring.data.sample.resource.CityResource;

/**
 * Register Jersey modules
 * 
 * @author Adriano Kretschmer
 */
@Configuration
@ApplicationPath("rest/")
public class Config extends ResourceConfig {

    public Config() {
        register(CityResource.class);
        packages("br.com.cinq.spring.data.sample.resource");
    }

}
package com.bmo.test.config;

import com.bmo.test.rest.PersonController;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.wadl.internal.WadlResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class JerseyConfig extends ResourceConfig {
    @Value("${spring.jersey.application-path}")
    private String apiPath;

    public JerseyConfig() {
        // Register endpoints, providers, ...
        this.register(CORSResponseFilter.class);
        this.registerEndpoints();
    }

    @PostConstruct
    public void init() {
        // Register components where DI is needed
        this.configureSwagger();
    }

    private void registerEndpoints() {
        this.register(PersonController.class);
        // Access through /<Jersey's servlet path>/application.wadl
        this.register(WadlResource.class);
    }

    private void configureSwagger() {
        // Available at localhost:port/api/swagger.json
        this.register(ApiListingResource.class);
        this.register(SwaggerSerializers.class);

        BeanConfig config = new BeanConfig();
        config.setConfigId("bmo-person-test");
        config.setTitle("BMO TEST");
        config.setVersion("v1");
        config.setContact("Dishant Patel");
        config.setSchemes(new String[] { "http" });
        config.setBasePath(this.apiPath);
        config.setResourcePackage("com.bmo.test.rest");
        config.setPrettyPrint(true);
        config.setScan(true);
    }
}

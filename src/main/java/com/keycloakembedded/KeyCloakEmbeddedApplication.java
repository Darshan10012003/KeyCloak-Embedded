package com.keycloakembedded;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

import com.keycloakembedded.properties.KeycloakServerProperties;

@SpringBootApplication
public class KeyCloakEmbeddedApplication {
	 private static final Logger LOG = LoggerFactory.getLogger(KeyCloakEmbeddedApplication.class);
	 
	public static void main(String[] args) {
		SpringApplication.run(KeyCloakEmbeddedApplication.class, args);
	}
	
	@Bean
    ApplicationListener<ApplicationReadyEvent> onApplicationReadyEventListener(
      ServerProperties serverProperties, KeycloakServerProperties keycloakServerProperties) {
        return (evt) -> {
            Integer port = serverProperties.getPort();
            String keycloakContextPath = "/auth";
            LOG.info("Embedded Keycloak started: http://localhost:{}{} to use keycloak", 
              port, keycloakContextPath);
        };
    }

}

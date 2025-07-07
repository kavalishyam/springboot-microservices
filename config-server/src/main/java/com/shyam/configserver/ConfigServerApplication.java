package com.shyam.configserver;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}
	
	@Bean
	ApplicationRunner runner() {
	    return args -> {
	        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
	        Resource[] resources = resolver.getResources("classpath:/configurations/*.yml");
	        for (Resource resource : resources) {
	            System.out.println("Loaded config file: " + resource.getFilename());
	        }
	    };
	}

}

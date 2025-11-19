package br.ucsal.bibliography_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BibliographyServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(BibliographyServiceApplication.class, args);
	}
}
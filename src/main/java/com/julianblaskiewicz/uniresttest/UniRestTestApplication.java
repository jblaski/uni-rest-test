package com.julianblaskiewicz.uniresttest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UniRestTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniRestTestApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(LearningProviderRepository repository) {
		return args -> {
			repository.insert(LearningProvider.builder()
					.UKPRN("10008640")
					.providerName("FALMOUTH UNIVERSITY")
					.alias("")
					.flatNameNumber("")
					.buildingNameNumber("Woodlane Campus")
					.locality("")
					.streetName("Woodlane")
					.town("Falmouth")
					.postcode("TR11 4RH")
					.websiteAddress("www.falmouth.ac.uk")
					.build()
			);
		};
	}

}

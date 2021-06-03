package com.julianblaskiewicz.uniresttest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@SpringBootApplication
@Slf4j
public class UniRestTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniRestTestApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(LearningProviderRepository repository, MongoTemplate mongoTemplate) {
		return args -> {
			String ukprn = "10008640";
			LearningProvider learningProvider = LearningProvider.builder()
					.UKPRN(ukprn)
					.providerName("FALMOUTH UNIVERSITY")
					.alias("")
					.flatNameNumber("")
					.buildingNameNumber("Woodlane Campus")
					.locality("")
					.streetName("Woodlane")
					.town("Falmouth")
					.postcode("TR11 4RH")
					.websiteAddress("www.falmouth.ac.uk")
					.build();

			//usingMongoTemplateAndQuery(repository, mongoTemplate, ukprn, learningProvider);

			repository.findLearningProviderByUKPRN(ukprn).ifPresentOrElse(lp -> log.warn(learningProvider.getProviderName() + " already exists"), () -> {
				log.info("Inserting learningProvider " + learningProvider.getProviderName());
				repository.insert(learningProvider);
			});

		};
	}

	private void usingMongoTemplateAndQuery(LearningProviderRepository repository, MongoTemplate mongoTemplate, String ukprn, LearningProvider learningProvider) {
		Query query = new Query();
		query.addCriteria(Criteria.where("UKPRN").is(ukprn));

		List<LearningProvider> learningProviders = mongoTemplate.find(query, LearningProvider.class);

		if (learningProviders.size() > 1) {
			throw new IllegalStateException("Found many LearningProviders with same UKPRN of " + ukprn);
		}

		if (learningProviders.isEmpty()) {
			log.info("Inserting learningProvider " + learningProvider.getProviderName());
			repository.insert(learningProvider);
		} else {
			log.warn(learningProvider.getProviderName() + " already exists");
		}
	}

}

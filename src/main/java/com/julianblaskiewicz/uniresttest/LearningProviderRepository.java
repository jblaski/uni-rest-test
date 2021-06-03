package com.julianblaskiewicz.uniresttest;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface LearningProviderRepository extends MongoRepository<LearningProvider, String> {

    Optional<LearningProvider> findLearningProviderByUKPRN(String ukprn);

}

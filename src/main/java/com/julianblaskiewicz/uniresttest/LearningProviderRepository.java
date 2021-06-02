package com.julianblaskiewicz.uniresttest;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LearningProviderRepository extends MongoRepository<LearningProvider, String> {
}

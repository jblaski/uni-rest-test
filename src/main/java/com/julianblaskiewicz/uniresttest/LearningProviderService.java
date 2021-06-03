package com.julianblaskiewicz.uniresttest;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class LearningProviderService {

    private final LearningProviderRepository learningProviderRepository;

    public List<LearningProvider> getAllLearningProviders() {
        return learningProviderRepository.findAll();
    }

}

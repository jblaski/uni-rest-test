package com.julianblaskiewicz.uniresttest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/learningprovider")
@AllArgsConstructor
public class LearningProviderController {

    private final LearningProviderService learningProviderService;

    @GetMapping
    public List<LearningProvider> fetchAllLearningProviders() {
        return learningProviderService.getAllLearningProviders();
    }
}

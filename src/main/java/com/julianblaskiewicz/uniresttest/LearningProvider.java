package com.julianblaskiewicz.uniresttest;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*  Headers and sample data:
    "UKPRN","PROVIDER_NAME","ALIAS","FLAT_NAME_NUMBER","BUILDING_NAME_NUMBER","LOCALITY","STREET_NAME","TOWN","POSTCODE","WEBSITE_ADDRESS"
    "10008640","FALMOUTH UNIVERSITY","","","Woodlane Campus","","Woodlane","Falmouth","TR11 4RH","www.falmouth.ac.uk"
*/

@Builder
@Data
@Document
public class LearningProvider {
    @Id
    private String id;
    private String UKPRN;
    private String providerName;
    private String alias;
    private String flatNameNumber;
    private String buildingNameNumber;
    private String locality;
    private String streetName;
    private String town;
    private String postcode;
    private String websiteAddress;
}

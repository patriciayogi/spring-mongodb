package com.pyogi.mongodb.airbnb.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Builder
@Data
public class ListingsAndReviews {
    @Id
    private String _id;

    private String listingUrl;
    private String name;
    private String space;
    private String description;
    private String neighborhoodOverview;
    private String propertyType;
    private String roomType;
    private String minimumNights;
    private String maximumNights;
    private String accommodates;
    private String number_of_reviews;
    private Float price;
    private Address address;

    @Data
    class Address {
        private String street;
        private String country;
        private String countryCode;
    }

}

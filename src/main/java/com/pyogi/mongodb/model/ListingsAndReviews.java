package com.pyogi.mongodb.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Builder
@EqualsAndHashCode
@ToString
public class ListingsAndReviews {
    @Id
    public String _id;

    public String listingUrl;
    public String name;
    public String space;
    public String description;
    public String neighborhoodOverview;
    public String propertyType;
    public String roomType;
    public String minimumNights;
    public String maximumNights;
    public String accommodates;

}

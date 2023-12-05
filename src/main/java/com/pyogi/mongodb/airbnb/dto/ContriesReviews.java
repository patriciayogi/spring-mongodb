package com.pyogi.mongodb.airbnb.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class ContriesReviews {
    @Id
    private String country;
    private Integer averageReviews;
}

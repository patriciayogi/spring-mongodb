package com.pyogi.mongodb.airbnb.controller;

import com.pyogi.mongodb.airbnb.dto.ContriesReviews;
import com.pyogi.mongodb.airbnb.model.ListingsAndReviews;
import com.pyogi.mongodb.airbnb.service.AirbnbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AirbnbController {

    @Autowired
    private AirbnbService airbnbService;

    @GetMapping("/airbnb/name")
    public ResponseEntity listByName(@RequestParam String name) {
        return ResponseEntity.status(HttpStatus.OK).body(airbnbService.listByName(name));
    }

    @GetMapping("/airbnb/id")
    public ResponseEntity listById(@RequestParam String id) {
        return ResponseEntity.status(HttpStatus.OK).body(airbnbService.listById(id));
    }

    @GetMapping("/airbnb/topRatedListings")
    public ResponseEntity<List<ListingsAndReviews>> topRatedListings(
            @RequestParam(name = "country", required = false, defaultValue = "CA") String country,
            @RequestParam(name = "maxPrice", required = false) Float maxPrice) {
        return ResponseEntity.status(HttpStatus.OK).body(airbnbService.threeTopScores(country, maxPrice));
    }


    @GetMapping("/airbnb/topRatedPerCountry")
    public ResponseEntity<List<ContriesReviews>> topRatedCountries() {
        return ResponseEntity.status(HttpStatus.OK).body(airbnbService.topRatedCountry());
    }
}

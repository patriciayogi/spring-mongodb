package com.pyogi.mongodb.airbnb.service;

import com.pyogi.mongodb.airbnb.model.ListingsAndReviews;
import com.pyogi.mongodb.airbnb.repository.ListAndReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirbnbService {

    @Autowired
    private ListAndReviewsRepository repository;

    public List<ListingsAndReviews> listByName(String name){
        return repository.findByName(name);
    }

    public Optional<ListingsAndReviews> listById(String id){
        return repository.findById(id);
    }
}

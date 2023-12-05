package com.pyogi.mongodb.repository;

import com.pyogi.mongodb.model.ListingsAndReviews;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ListAndReviewsRepository extends MongoRepository<ListingsAndReviews, String>  {

    public List<ListingsAndReviews> findByName(String lastName);

}


package com.pyogi.mongodb.airbnb.repository;

import com.pyogi.mongodb.airbnb.model.ListingsAndReviews;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListAndReviewsRepository extends MongoRepository<ListingsAndReviews, String>  {

    List<ListingsAndReviews> findByName(String lastName);

}


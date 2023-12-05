package com.pyogi.mongodb.airbnb.service;

import com.pyogi.mongodb.airbnb.dto.ContriesReviews;
import com.pyogi.mongodb.airbnb.model.ListingsAndReviews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Service
public class AirbnbService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<ListingsAndReviews> listByName(String name) {
        return mongoTemplate.find(Query.query(Criteria.where("name").is(name)), ListingsAndReviews.class);
    }

    public ListingsAndReviews listById(String id) {
        return mongoTemplate.findById(id, ListingsAndReviews.class);
    }

    public List<ListingsAndReviews> threeTopScores(String country, Float maxPrice) {

        MatchOperation filterCountry = match(new Criteria("address.country_code").is(country));
        MatchOperation filterPrices = match(new Criteria("price").lt(Optional.ofNullable(maxPrice).orElse(Float.MAX_VALUE)));
        SortOperation sortByReviewsDesc = sort(Sort.by(Sort.Direction.DESC, "reviews"));
        SortOperation sortByPricesAsc = sort(Sort.by(Sort.Direction.DESC, "price"));
        LimitOperation limit = limit(3);

        Aggregation aggregation = newAggregation(filterCountry,
                sortByReviewsDesc, filterPrices, sortByPricesAsc, limit);

        AggregationResults<ListingsAndReviews> result = mongoTemplate
                .aggregate(aggregation, "listingsAndReviews", ListingsAndReviews.class);

        return result.getMappedResults();
    }

    public List<ContriesReviews> topRatedCountry() {

        GroupOperation groupByAreaAndSumReviews = group("address.country_code")
                .avg("review_scores.review_scores_rating").as("averageReviews");
        SortOperation sortByReviewsDesc = sort(Sort.by(Sort.Direction.DESC, "averageReviews"));

        Aggregation aggregation = newAggregation(
                groupByAreaAndSumReviews, sortByReviewsDesc);

        AggregationResults<ContriesReviews> result = mongoTemplate
                .aggregate(aggregation, "listingsAndReviews", ContriesReviews.class);

        return result.getMappedResults();
    }

}

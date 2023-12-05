package com.pyogi.mongodb;

import com.pyogi.mongodb.config.CredentialsProperties;
import com.pyogi.mongodb.model.ListingsAndReviews;
import com.pyogi.mongodb.repository.ListAndReviewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(CredentialsProperties.class)
@SpringBootApplication
public class MongodbApplication implements CommandLineRunner { // TODO remove

	@Autowired
	private ListAndReviewsRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(MongodbApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

		System.out.println();

		// fetch an individual id
		System.out.println("--------------------------------");
		System.out.println(repository.findById("1003530"));

		System.out.println("Customers found with findByName:");
		System.out.println("--------------------------------");
		for (ListingsAndReviews listings : repository.findByName("New York City - Upper West Side Apt")) {
			System.out.println(listings);
		}
	}
}

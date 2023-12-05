package com.pyogi.mongodb.airbnb.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;


@Configuration
public class MongoConfig {

    @Autowired
    private CredentialsProperties config;

    @Bean
    public MongoClient mongo() {
        StringBuilder uri = new StringBuilder("mongodb+srv://")
                .append(config.getUser())
                .append(":")
                .append(config.getPassword())
                .append("@")
                .append(config.getCluster());

        ConnectionString connectionString = new ConnectionString(uri.toString());
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), config.getName());
    }

}
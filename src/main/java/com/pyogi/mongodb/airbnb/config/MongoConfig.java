package com.pyogi.mongodb.airbnb.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;


@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Autowired
    private CredentialsProperties config;
    
    @Override
    protected String getDatabaseName() {
        return config.getCollection();
    }

    @Override
    public MongoClient mongoClient() {

        String uri = "mongodb+srv://" + config.getUser() + ":" + config.getPassword() + "@" + config.getCluster();

        ConnectionString connectionString = new ConnectionString(uri);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

}
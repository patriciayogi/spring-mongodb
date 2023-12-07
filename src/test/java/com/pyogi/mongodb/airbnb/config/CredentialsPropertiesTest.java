package com.pyogi.mongodb.airbnb.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = {
                CredentialsProperties.class
        })
@EnableConfigurationProperties
public class CredentialsPropertiesTest {

    @Autowired
    private CredentialsProperties credentialsProperties;

    @Test
    public void getConnectionString() {
        Assert.assertEquals(credentialsProperties.getConnectionString().getConnectionString(), "mongodb+srv://user:password@cluster.mongodb.net");
    }
}


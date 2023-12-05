package com.pyogi.mongodb.airbnb.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationProperties("database")
@ConfigurationPropertiesScan
@Data
public class CredentialsProperties {

	private String user;
	private String password;
	private String cluster;
	private String collection;

}

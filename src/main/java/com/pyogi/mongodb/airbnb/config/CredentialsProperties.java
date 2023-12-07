package com.pyogi.mongodb.airbnb.config;

import com.mongodb.ConnectionString;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationProperties("database")
@ConfigurationPropertiesScan
@Data
public class CredentialsProperties {

    public static final String MONGODB_SRV = "mongodb+srv://";
    private String user;
    private String password;
    private String cluster;
    private String name;

    public ConnectionString getConnectionString() {
        StringBuilder uri = new StringBuilder(MONGODB_SRV)
                .append(getUser())
                .append(":")
                .append(getPassword())
                .append("@")
                .append(getCluster());

        return new ConnectionString(uri.toString());
    }

}

package com.example;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

	@Value("${spring.data.mongodb.uri}")
    private String mongodbUri;
	
	@Value("${spring.data.mongodb.database}")
    private String database;
    
    @Override
    protected String getDatabaseName() {
        return database;
    }
	@Bean(name = "mongoTransactionManager")
	@Primary
    MongoTransactionManager mongoTransactionManager(MongoDatabaseFactory dbFactory) {  
        return new MongoTransactionManager(dbFactory);
    }
        
	@Bean
    MongoOperations mongoOperations(MongoDatabaseFactory dbFactory) {  
        return new MongoTemplate(dbFactory);
    }
	
    @Override
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString(mongodbUri);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .build();
        
        return MongoClients.create(mongoClientSettings);
    }
 
    @Override
    public Collection getMappingBasePackages() {
        return Collections.singleton("com.example");
    }
}
package com.gini.config;

import com.amazon.athena.jdbc.AthenaDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.SQLException;

@Configuration
public class AthenaConfig {

    @Bean
    public Connection athenaConnection(AthenaDataSource athenaDataSource) throws SQLException {

//        String url = "jdbc:athena://";
//        AthenaDriver driver = new AthenaDriver();
//        return driver.connect(url, athenaConnectionProperties);

        var x = athenaDataSource.getConnection();

        return x;


//        Statement statement = connection.createStatement();
//        String query = "SELECT * from sample_table LIMIT 10";
//        ResultSet resultSet = statement.executeQuery(query);
    }

    @Bean
    public AthenaDataSource athenaConnectionProperties() {
        AthenaDataSource dataSource = new AthenaDataSource();
        dataSource.setWorkGroup("primary");
        dataSource.setRegion("us-east-2");
        dataSource.setCatalog("AwsDataCatalog");
        dataSource.setDatabase("sampledatabase");
        dataSource.setOutputLocation("s3://samplebucket");
//        dataSource.setCredentialsProvider("DefaultChain");
        dataSource.setUser("user");
        dataSource.setPassword("password");

        return dataSource;

    }


}

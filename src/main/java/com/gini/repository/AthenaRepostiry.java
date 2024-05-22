package com.gini.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
@RequiredArgsConstructor
public class AthenaRepostiry {

    private final Connection connection;


    public void getShit() {

        String query = "SELECT * from sample_table LIMIT 10";

        try (PreparedStatement statement = connection.prepareStatement(query)) {

            var rs = statement.executeQuery();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}

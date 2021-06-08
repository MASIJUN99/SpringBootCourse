package com.sample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class ApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();

        String[] sqls = {
                "INSERT INTO user(name, password) values('user1', 'psw1')",
                "INSERT INTO user(name, password) values('user2', 'psw2')",
                "INSERT INTO user(name, password) values('user3', 'psw3')",
                "INSERT INTO user(name, password) values('user4', 'psw4')"
        };
        for (String sql : sqls) {
            jdbcTemplate.execute(sql);
        }

        System.out.println(connection);
        connection.close();
    }

}

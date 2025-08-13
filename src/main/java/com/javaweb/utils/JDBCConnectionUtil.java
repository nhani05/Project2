package com.javaweb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class JDBCConnectionUtil {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    private static String URL;
    private static String USER_NAME;
    private static String PASS_WORD;

    @PostConstruct
    public void init() {
        URL = this.url;
        USER_NAME = this.username;
        PASS_WORD = this.password;
    }

    public static Connection getConnections() {
        try {
            return DriverManager.getConnection(URL, USER_NAME, PASS_WORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

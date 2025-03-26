package com.empresa.config;
import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;

@Singleton
@Startup
@DataSourceDefinition(
    name = "java:app/jdbc/h2DS",
    className = "org.h2.jdbcx.JdbcDataSource",
    url = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;MODE=MYSQL",
    user = "sa",
    password = "sa"
)
public class DatabaseConfig {}

package com.mfoumby.pizzawebsitebackend.shared;

import com.mfoumby.pizzawebsitebackend.properties.DbProperties;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class DbManager {
    private final HikariDataSource dataSource;

    public DbManager(DbProperties dbProperties) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dbProperties.url());
        config.setUsername(dbProperties.user());
        config.setPassword(dbProperties.password());
        dataSource = new HikariDataSource(config);
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}

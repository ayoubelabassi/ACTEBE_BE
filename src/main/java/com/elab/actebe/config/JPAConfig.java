package com.elab.actebe.config;

import com.elab.actebe.domaine.security.User;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAwareRef")
public class JPAConfig {

    @Inject
    private Environment env;


    @Bean
    public AuditorAware<User> auditorAware(){
        return new AuditorAwareImpl();
    }

    @Bean
    public DataSource createDataSourceBean(){
        DataSource ds = new org.apache.tomcat.jdbc.pool.DataSource();
        ds.setDriverClassName(this.env.getProperty("spring.datasource.driver-class-name"));

        ds.setMaxActive(Integer.parseInt(this.env.getProperty("spring.datasource.tomcat.max-active")));
        ds.setMaxIdle(Integer.parseInt(this.env.getProperty("spring.datasource.tomcat.max-idle")));
        ds.setMinIdle(Integer.parseInt(this.env.getProperty("spring.datasource.tomcat.min-idle")));
        ds.setInitialSize(Integer.parseInt(this.env.getProperty("spring.datasource.tomcat.initial-size")));

        ds.setValidationQuery(this.env.getProperty("spring.datasource.tomcat.validationQuery"));
        ds.setTestOnBorrow(Boolean.parseBoolean(this.env.getProperty("spring.datasource.tomcat.testOnBorrow")));
        ds.setTestWhileIdle(Boolean.parseBoolean(this.env.getProperty("spring.datasource.test-while-idle")));
        ds.setTimeBetweenEvictionRunsMillis(Integer.parseInt(this.env.getProperty("spring.datasource.time-between-eviction-runs-millis")));
        ds.setMinEvictableIdleTimeMillis(Integer.parseInt(this.env.getProperty("spring.datasource.min-evictable-idle-time-millis")));

        ds.setUrl(this.env.getProperty("spring.datasource.url"));
        ds.setUsername(this.env.getProperty("spring.datasource.username"));
        ds.setPassword(this.env.getProperty("spring.datasource.password"));

        return ds;
    }

    @Bean
    public Connection createConnection(){
        Connection connection=null;
        try {
            Class.forName(this.env.getProperty("spring.datasource.driver-class-name"));
            connection = DriverManager.getConnection(this.env.getProperty("spring.datasource.url"),this.env.getProperty("spring.datasource.username"),
                    this.env.getProperty("spring.datasource.password"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

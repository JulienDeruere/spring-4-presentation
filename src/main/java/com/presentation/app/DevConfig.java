package com.presentation.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author jderuere
 */
@Profile({"default", "dev"})
@Configuration
public class DevConfig {

    @Bean(destroyMethod = "close")
    public DataSource dataSource() throws PropertyVetoException {
        JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        dsLookup.setResourceRef(true);
        return dsLookup.getDataSource("jdbc/presentation");
    }
}

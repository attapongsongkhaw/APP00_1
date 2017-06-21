package com.kbank.lms.common;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;


@Profile("Prod")
@Configuration
public class DataSourceConfig {
	
	private static final Logger logger = Logger.getLogger(DataSourceConfig.class);

	@Bean@ ConfigurationProperties(prefix = "lms.datasource.primary")
    public JndiPropertyHolder primary() {
        return new JndiPropertyHolder();
    }
	
    @Bean
    public DataSource dataSource() {
    	DataSource dataSource = null;
    	try {
	        JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
            dataSource = dataSourceLookup.getDataSource(primary().getJndiName());
    	} catch(Exception e){
    		logger.error(e);
    		throw e;
    	}
    	return dataSource;
    }

    private static class JndiPropertyHolder {
        private String jndiName;

        public String getJndiName() {
            return jndiName;
        }

        @SuppressWarnings("unused")
		public void setJndiName(String jndiName) {
            this.jndiName = jndiName;
        }
    }
}

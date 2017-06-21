package com.kbank.lms.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class DataSorceConfig {
	/**
	public static final String TEST_CORPORATION = "unit-testCorporation";
	public static final String TEST_ACCOUNT     = "unit-testAccount";
	public static final String TEST_CLIENT      = "unit-testClient";
	public static final String TEST_USER        = "unit-testUser";
	public static final String TEST_FUNCTION    = "unit-testFunction";
	public static final String TEST_UMMSERVICE = "unit-testUMM";
	*/
	public static final String UNIT_TEST_LMS = "unitTestLMS";

	private static final Logger logger = LoggerFactory.getLogger(DataSorceConfig.class);

	/***
	@Profile(TEST_CORPORATION)
	@Bean(name="dataSource")
	public DataSource dataSourceTestCorporation() {
		EmbeddedDatabase db = null;
		try {
			EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
			db = builder.setType(EmbeddedDatabaseType.HSQL)
				.addScript("db/table/CORPORATION_TMP.sql")
				.addScript("db/table/CORPORATION_MST.sql")
				.addScript("db/table/ACCOUNT_TMP.sql")
				.addScript("db/table/ACCOUNT_MST.sql")
				//.addScript("db/table/INSERT_CORPORATION_MST.sql")
				.build();
		} catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return db;
	}

	@Profile(TEST_ACCOUNT)
	@Bean(name="dataSource")
	public DataSource dataSourceTestAccount() {
		EmbeddedDatabase db = null;
		try {
			EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
			db = builder.setType(EmbeddedDatabaseType.HSQL)
				.addScript("db/table/CORPORATION_TMP.sql")
				.addScript("db/table/CORPORATION_MST.sql")
				.addScript("db/table/ACCOUNT_TMP.sql")
				.addScript("db/table/ACCOUNT_MST.sql")
				//.addScript("db/table/INSERT_CORPORATION_MST.sql")
				.build();
		} catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return db;

	}

	@Profile(TEST_CLIENT)
	@Bean(name="dataSource")
	public DataSource dataSourceTestClient() {
		EmbeddedDatabase db = null;
		try {
			EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
			db = builder.setType(EmbeddedDatabaseType.HSQL)
				.addScript("db/table/CLIENT_TMP.sql")
				.addScript("db/table/CLIENT_MST.sql")
				.addScript("db/table/INSERT_CLIENT_MST.sql")
				.build();
		} catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return db;

	}

	@Profile(TEST_FUNCTION)
	@Bean(name="dataSource")
	public DataSource dataSourceTestFunction() {
		EmbeddedDatabase db = null;
		try {
			EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
			db = builder.setType(EmbeddedDatabaseType.HSQL)
				.addScript("db/table/CORP_FUNC_MST.sql")
				.addScript("db/table/CORP_FUNC_TMP.sql")
				.addScript("db/table/INSERT_CORP_FUNC_MST.sql")
				.build();
		} catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return db;

	}

	@Profile(TEST_USER)
	@Bean(name="dataSource")
	public DataSource dataSourceTestUser() {
		EmbeddedDatabase db = null;
		try {
			EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
			db = builder.setType(EmbeddedDatabaseType.HSQL)
				.addScript("db/table/USER_TMP.sql")
				.addScript("db/table/USER_MST.sql")
				.addScript("db/table/USER.sql")
				.build();
		} catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return db;
	}

	@Profile(UNIT_TEST_LMS)
	@Bean(name="dataSource")
	public DataSource dataSourceTestUMMSERVICE() {
		EmbeddedDatabase db = null;
		try {
			EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
			db = builder.setType(EmbeddedDatabaseType.HSQL)
				.addScript("db/table/CORPORATION_TMP.sql")
				.addScript("db/table/CORPORATION_MST.sql")
				.addScript("db/table/ACCOUNT_TMP.sql")
				.addScript("db/table/ACCOUNT_MST.sql")
				.addScript("db/table/USER_TMP.sql")
				.addScript("db/table/USER_MST.sql")
				.build();
		} catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return db;
	}
	 */	
	@Profile(UNIT_TEST_LMS)
	@Bean(name="dataSource")
	public DataSource dataSourceTestLMS() {
		EmbeddedDatabase db = null;
		try {
			EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
			db = builder.setType(EmbeddedDatabaseType.HSQL)
					.addScript("db/table/USER_TMP.sql")
					.addScript("db/table/USER_MST.sql")
					.addScript("db/table/CLIENT_TMP.sql")
					.addScript("db/table/CLIENT_MST.sql")
					.addScript("db/table/ACCOUNT_TMP.sql")
					.addScript("db/table/ACCOUNT_MST.sql")
					.addScript("db/table/CORPORATION_TMP.sql")
					.addScript("db/table/CORPORATION_MST.sql")
					.addScript("db/table/CORP_FUNC_MST.sql")
					.addScript("db/table/CORP_FUNC_TMP.sql")
					.build();
		} catch(Exception ex){
			logger.error(ex.getMessage());
		}
		return db;
	}


	// Start WebServer, access http://localhost:8082
	/*@Bean(initMethod = "start", destroyMethod = "stop")
	public Server startDBManager() throws SQLException {
		return Server.createWebServer();
	}*/
}

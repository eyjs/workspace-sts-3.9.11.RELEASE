/**
 * 
 */
package com.mybatis3.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Siva
 *
 */
public class TestDataPopulatorMain {
	private static Logger logger = LoggerFactory.getLogger(TestDataPopulatorMain.class);
	private static final Properties PROPERTIES = new Properties();
	/**************** ScriptRunner **********************/
	static {
		/*
		try {
			InputStream is = DataSourceFactory.class.getResourceAsStream("/jdbc.properties");
			PROPERTIES.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
	}
	
	public static void main(String[] args) {
		initDatabase();
	}
	

	public static Connection getConnection() {
		String driver = PROPERTIES.getProperty("jdbc.driverClassName");
		String url = PROPERTIES.getProperty("jdbc.url");
		String username = PROPERTIES.getProperty("jdbc.username");
		String password = PROPERTIES.getProperty("jdbc.password");
		Connection connection = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return connection;
	}
	/*******************************************************/
	public static void initDatabase() {
		/*
		Connection connection = null;
		Reader reader = null;
		try {
			connection = getConnection();
			ScriptRunner scriptRunner = new ScriptRunner(connection);
			reader = Resources.getResourceAsReader("sql/drop_tables.sql");
			scriptRunner.runScript(reader);
			logger.info("drop_tables.sql executed successfully");
			reader = Resources.getResourceAsReader("sql/create_tables.sql");
			scriptRunner.runScript(reader);
			logger.info("create_tables.sql executed successfully");
			reader = Resources.getResourceAsReader("sql/sample_data.sql");
			scriptRunner.runScript(reader);
			logger.info("sample_data.sql executed successfully");
			connection.commit();
			reader.close();
			scriptRunner.closeConnection();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		*/
	}
}

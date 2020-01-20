package it.org.example.dao;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.spi.PersistenceUnitTransactionType;

import org.eclipse.persistence.config.TargetServer;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.eclipse.persistence.config.PersistenceUnitProperties.*;

public class DaoBaseIT {

	public static EntityManagerFactory entityManagerFactory;
	public EntityManager entityManager;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@BeforeClass
	public static void beforeClassInit() {
		Map properties = new HashMap();

		properties.put(TRANSACTION_TYPE, PersistenceUnitTransactionType.RESOURCE_LOCAL.name());

		properties.put(JDBC_DRIVER, "org.apache.derby.jdbc.EmbeddedDriver");
		properties.put(JDBC_URL, "jdbc:derby:/target/derbyDB/exampleDb;create=true");
		properties.put(JDBC_USER, "user");
		properties.put(JDBC_PASSWORD, "password");
		
		properties.put(DDL_GENERATION, "drop-and-create-tables");
		properties.put(DDL_GENERATION_MODE, "both");
		properties.put(CREATE_JDBC_DDL_FILE, "target/create.sql");
		properties.put(DROP_JDBC_DDL_FILE, "target/drop.sql");
		
		//By default sql bind parameters are displayed in exceptions and logs
	    // when the log level is FINE or greater.
		properties.put(LOGGING_LEVEL, "FINE");
		properties.put(LOGGING_TIMESTAMP, "false");
		properties.put(LOGGING_THREAD, "false");
		properties.put(LOGGING_SESSION, "false");

		properties.put(TARGET_SERVER, TargetServer.None);

		entityManagerFactory = Persistence.createEntityManagerFactory("example", properties);
	}

	@Before
	public void beforeInit() {
		entityManager = entityManagerFactory.createEntityManager();
	}

	@AfterClass
	public static void afterClassTeardown() {
		entityManagerFactory.close();
	}
}

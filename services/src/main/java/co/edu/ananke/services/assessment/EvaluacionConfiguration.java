package io.pivotal.microservices.accounts;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

/**
 
 * @author SantiPurdy
 */
@Configuration
@ComponentScan
@EntityScan("io.pivotal.microservices.accounts")
@EnableJpaRepositories("io.pivotal.microservices.accounts")
@PropertySource("classpath:db-config.properties")



public class EvaluacionesConfiguration {

	protected Logger logger;

	public EvaluacionesConfiguration() {

		logger = Logger.getLogger(getEvaluacion().getUsuaios());
	}

	
	@Bean
	public DataSource dataSource() {
		logger.info("dataSource() invoked");

		// Create an in-memory H2 relational database containing some demo
		// accounts.
		DataSource dataSource = (new EmbeddedDatabaseBuilder()).addScript("classpath:testdb/schema.sql")
				.addScript("classpath:testdb/data.sql").build();

		logger.info("dataSource = " + dataSource);

		// Sanity check
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<int, Object>> accounts = jdbcTemplate.queryForList("SELECT number FROM Evaluacion");

		logger.info("System has " + evaluaciones.size() + " evaluaciones");

		
		
	}
}

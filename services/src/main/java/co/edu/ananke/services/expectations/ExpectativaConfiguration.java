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

public class ExpectativasConfiguration {

	protected Logger logger;

	public ExpectativasConfiguration() {

		logger = Logger.getLogger(getExpectativa().getUsuarios());
	}

	
	@Bean
	public DataSource dataSource() {
		logger.info("dataSource() invoked");

		
		DataSource dataSource = (new EmbeddedDatabaseBuilder()).addScript("classpath:testdb/schema.sql")
				.addScript("classpath:testdb/data.sql").build();

		logger.info("dataSource = " + dataSource);

		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		List<Map<String, Object>> expectativas = jdbcTemplate.queryForList("SELECT number FROM Expectativa");
		logger.info("System has " + expectativas.size() + " expectativas");


		
	}
}

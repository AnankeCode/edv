package  co.edu.ananke.services.recommendations;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.sql.DataSource;

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
@EntityScan(" co.edu.ananke.services.recommendations")
@EnableJpaRepositories(" co.edu.ananke.services.recommendations")
@PropertySource("classpath:db-config.properties")
public class RecomendacionConfiguration {

	protected Logger logger;

	public RecomendacionConfiguration() {
		logger = Logger.getLogger(getClass().getName());
	}

	/**
	 * Creates an in-memory "rewards" database populated with test data for fast
	 * testing
	 */
	@Bean
	public DataSource dataSource() {
		logger.info("dataSource() invoked");

		

		// Sanity check
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> accounts = jdbcTemplate.queryForList("SELECT number FROM Recomendacion");

		logger.info("System has " + recomendaciones.size() + " recomendaciones");


		
	}
}

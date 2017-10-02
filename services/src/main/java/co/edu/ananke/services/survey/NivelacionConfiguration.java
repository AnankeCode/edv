package co.edu.ananke.services.survey;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 
 * @author SantiPurdy
 */
@Configuration
@ComponentScan
@EntityScan("co.edu.ananke.services.survey")
@EnableJpaRepositories("co.edu.ananke.services.survey")
@PropertySource("classpath:db-config.properties")
public class NivelacionConfiguration {

	protected Logger logger;

	public NivelacionConfiguration() {
		logger = Logger.getLogger(getClass().getName());
	}

	
	@Bean
	

		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> accounts = jdbcTemplate.queryForList("SELECT number FROM Nivelacion");

		logger.info("System has " + nivelacion.size() + " nivelacion");


		
	
}

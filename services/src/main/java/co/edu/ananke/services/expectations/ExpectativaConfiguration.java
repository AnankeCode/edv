package co.edu.ananke.services.expectations;

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
@EntityScan("io.pivotal.microservices.accounts")
@EnableJpaRepositories("io.pivotal.microservices.accounts")
@PropertySource("classpath:db-config.properties")

public class ExpectativaConfiguration {

	protected Logger logger;

	public ExpectativaConfiguration() {

		logger = Logger.getLogger(getExpectativa().getUsuarios());
	}

	
	@Bean
	

		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		List<Map<String, Object>> expectativas = jdbcTemplate.queryForList("SELECT number FROM Expectativa");
		logger.info("System has " + expectativa.size() + " expectativas");


		
	}

    
}

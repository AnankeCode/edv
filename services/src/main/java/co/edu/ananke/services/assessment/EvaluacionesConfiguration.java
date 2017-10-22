package co.edu.ananke.services.assessment;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

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
@EntityScan(" co.edu.ananke.services.assessment")
@EnableJpaRepositories(" co.edu.ananke.services.assessment")
@PropertySource("classpath:db-config.properties")



public class EvaluacionesConfiguration {

	protected Logger logger;
    private Object evaluaciones;

	public EvaluacionesConfiguration() {

		logger = Logger.getLogger(getEvaluacion().getUsuaios());
	}

	
	@Bean
	public DataSource dataSource() {
		logger.info("dataSource() invoked");

		
		// Sanity check
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<int, Object>> evaluaciones = jdbcTemplate.queryForList("SELECT number FROM Evaluacion");

            Logger info = logger.log(Level.INFO, "System has {0} evaluaciones", evaluaciones.size());

    
		
		
	


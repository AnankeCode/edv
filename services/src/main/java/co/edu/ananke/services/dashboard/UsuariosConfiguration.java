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
public class UsuariosConfiguration {

	protected Logger logger;

	public UsuariosConfiguration() {
		logger = Logger.getLogger(getClass().getName());
	}

	
	@Bean
	public DataSource dataSource() {
		logger.info("dataSource() invoked");

		

		DataSource dataSource = (new EmbeddedDatabaseBuilder()).addScript("classpath:testdb/.sql")
				.addScript("classpath:testdb/.sql").build();


		logger.info("dataSource = " + dataSource);

		
		List<Map<String, Object>> usuarios = jdbcTemplate.queryForList("SELECT number FROM Usuarios");
		logger.info("System has " + usuarios.size() + " usuarios");


	
	}
}

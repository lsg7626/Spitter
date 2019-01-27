package e.g.spitter.config;

import javax.sql.DataSource;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfig {

	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUsername("hr");
		ds.setPassword("hr");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		return ds;
	}
}
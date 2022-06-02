package com.mycompany.backend.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Configuration
public class DataSourceConfig {
	@Bean //관리 객체로 만들어준다.dataSource()라는 메소드 이름으로 관리 하는데, return 되는 값을 관리 객체로 둔다. 해당 메소드는 여러번 실행하는 메소드가 아니라 애플리케이션이 로딩될 때 딱 한 번 실행된다 
	public DataSource dataSource() {
		log.info("실행");
		HikariConfig config = new HikariConfig();
		config.setDriverClassName("oracle.jdbc.OracleDriver");
		config.setJdbcUrl("jdbc:oracle:thin:@kosa1.iptime.org:50120:orcl");
		config.setUsername("spring");
		config.setPassword("oracle");
		config.setMaximumPoolSize(3);
		HikariDataSource hikariDataSource = new HikariDataSource(config);
		return hikariDataSource;
	}
}

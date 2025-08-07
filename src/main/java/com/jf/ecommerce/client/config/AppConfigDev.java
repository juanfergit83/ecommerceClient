package com.jf.ecommerce.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("dev")
public class AppConfigDev {

  @Value("${environment.database-url}")
  private String url;

  @Value("${environment.database-username}")
  private String userName;

  @Value("${environment.database-password}")
  private String password;

  @Bean
  public DataSource dataSourceDev() {
    DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
    dataSourceBuilder.url(url);
    dataSourceBuilder.username(userName);
    dataSourceBuilder.password(password);
    return dataSourceBuilder.build();
  }



}

package com.springmvc.config;

import com.springmvc.session.AuthContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class SessionConfig {


  @Bean
  @Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
  @SessionScope
  public AuthContext authContext() {
    return new AuthContext();
  }
}

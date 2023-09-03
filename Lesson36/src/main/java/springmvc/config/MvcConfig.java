package springmvc.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.springframework.web.servlet.handler.MappedInterceptor;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

import springmvc.interceptor.AuthInterceptor;
import springmvc.session.AuthContext;
import springmvc.validation.EmailValidator;


import java.util.List;

@Configuration
@RequiredArgsConstructor
public class MvcConfig implements WebMvcConfigurer {

  private final AuthContext authContext;

  private static final List<String> ALLOWED_PATHS = List.of("/login", "/registration1", "/main");

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/accessDenied").setViewName("accessDenied");
    registry.addViewController("/login").setViewName("login");
    registry.addViewController("/registration").setViewName("registration");
    registry.addViewController("/step").setViewName("registration1");
    registry.addViewController("/homePage").setViewName("homePage");
    registry.addViewController("/myTenders").setViewName("myTenders");
    registry.addViewController("/createTender").setViewName("createTender");
    registry.addViewController("/personal").setViewName("personal");
    registry.addViewController("/search").setViewName("search");
    registry.addViewController("/organization").setViewName("organization");
    registry.addViewController("/users").setViewName("users");
    registry.addViewController("/addUser").setViewName("addUser");
    registry.addViewController("/tender").setViewName("tender");
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new MappedInterceptor(new String[]{"/*"},
        new AuthInterceptor(authContext))).excludePathPatterns(ALLOWED_PATHS);
  }

  @Bean
  public IDialect conditionalCommentDialect() {
    return new Java8TimeDialect();
  }

  @Bean
  public EmailValidator usernameValidator() {
    return new EmailValidator();
  }
}


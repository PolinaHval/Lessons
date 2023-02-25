package springmvc.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.MappedInterceptor;
import springmvc.interceptor.AuthInterceptor;
import springmvc.session.AuthContext;

@Configuration
@RequiredArgsConstructor
public class MvcConfig implements WebMvcConfigurer {

  private final AuthContext authContext;

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/accessDenied").setViewName("accessDenied");
    registry.addViewController("/login").setViewName("login");
    registry.addViewController("/registration").setViewName("registration");
    registry.addViewController("/users").setViewName("users");
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new MappedInterceptor(new String[]{"/users"}, new AuthInterceptor(authContext)));
  }
}
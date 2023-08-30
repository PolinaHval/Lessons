package springmvc.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//import org.springframework.context.annotation.ScopedProxyMode;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
//
//import springmvc.session.AuthContext;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class SecurityConfig extends AbstractSecurityWebApplicationInitializer {
//
////  private final JwtFilter jwtFilter;
////
////
////  @Bean
////  public SecurityFilterChain securityFilterChain(final HttpSecurity http) throws Exception {
////    http
////        .httpBasic().disable()
////        .csrf().disable()
////        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
////        .and()
////        .authorizeRequests()
////        .antMatchers("/login", "/registration", "/registration1", "/main").permitAll()
////        .and()
////        .authorizeRequests().antMatchers("/homePage")
////        .authenticated()
////        .and()
////        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
////        .logout(LogoutConfigurer::permitAll);
////    return http.build();
////  }
//
//
//  @Bean
//  public PasswordEncoder passwordEncoder() {
//    return new BCryptPasswordEncoder();
//  }
//
//  @Bean
//  @Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
//  public AuthContext authContext() {
//    return new AuthContext();
//  }
//
//}


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import springmvc.session.AuthContext;

@Configuration
public class SecurityConfig {

//  @Bean
//  public SecurityFilterChain securityFilterChain(final HttpSecurity http) throws Exception {
//    http
//        .formLogin().disable()
//        .httpBasic().disable()
//        .csrf().disable()
//        .authorizeHttpRequests((requests) -> requests
//            .antMatchers("/", "/login", "/registration").permitAll()
//            .anyRequest().authenticated()
//        )
//        .formLogin()
//        .permitAll()
//        .and()
//        .logout((logout) -> logout.permitAll());
//
//    return http.build();
//  }
//
//  @Bean
//  public PasswordEncoder passwordEncoder() {
//    return new BCryptPasswordEncoder();
//  }

  @Bean
  @Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
  public AuthContext authContext() {
    return new AuthContext();
  }

}

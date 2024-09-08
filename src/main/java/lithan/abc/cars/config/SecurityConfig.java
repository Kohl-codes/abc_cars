package lithan.abc.cars.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public static PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Autowired
  AuthenticationSuccessHandler successHandler;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    // Authorize
    http.authorizeRequests(configurer -> configurer
        .antMatchers("/css/**", "/images/**", "/js/**").permitAll()
        .antMatchers("/").permitAll()
        .antMatchers("/cars/**").permitAll()
        .antMatchers("/register/**").permitAll()

        .antMatchers("/user/**").hasRole("USER")
        .antMatchers("/car-bid/**").hasRole("USER")
        .antMatchers("/test-drive/**").hasRole("USER")

        .antMatchers("/admin/**").hasRole("ADMIN"));

    // Form Login
    http.formLogin(form -> form
        .loginPage("/login")
        .loginProcessingUrl("/loginUser")
        .successHandler(successHandler)
        .permitAll());

    // Logout
    http.logout(logout -> logout
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .permitAll());

    return http.build();
  }
}
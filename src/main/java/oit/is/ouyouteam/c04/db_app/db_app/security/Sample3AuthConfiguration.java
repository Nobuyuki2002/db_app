package oit.is.ouyouteam.c04.db_app.db_app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class Sample3AuthConfiguration {
	@Bean
    public InMemoryUserDetailsManager userDetailsService() {

      UserBuilder users = User.builder();

      // password: miren
      UserDetails riku = users
          .username("riku")
          .password("$2y$10$z1yfzTioUyaK6OJxXBZzw.7uzQ/6nARiW1ZdUb7Ty9WWgZ96O2uk2")
          .roles("RIKU")
          .build();
      // password: nobu
      UserDetails mugi = users
          .username("mugi")
          .password("$2y$10$hknbRnR94Pt1XyjEuemK2uDEAXJN257y.93yCkFyj4ZSHmr9D9jTy")
          .roles("MUGI")
          .build();

      return new InMemoryUserDetailsManager(riku, mugi);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

      http.formLogin();

      http.authorizeHttpRequests().mvcMatchers("/sample4/**").authenticated();

      http.logout().logoutSuccessUrl("/");

      http.csrf().disable();
      http.headers().frameOptions().disable();
      return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
    }
}

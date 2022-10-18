package main.java.oit.is.ouyouteam.c04.db_app.db_app.security;

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
				.password("$2y$10$PsdVJRM8G.D/nL2KNOgNm.0qOrDd867dlu2WKcyqNtPSjBTPorcNG")
				.roles("RIKU")
				.build();
		// password: nobu
		UserDetails mugi = users
				.username("mugi")
				.password("$2y$10$XTXq.UjPVMUX3qOHBKdAjOYijhrxqaV1SajRuC3GxwAUlZGt39vSy")
				.roles("MUGI")
				.build();

		return new InMemoryUserDetailsManager(riku, mugi);
	}
}

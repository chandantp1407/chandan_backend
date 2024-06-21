package com.excelsoft.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.excelsoft.service.UserEntityDetailService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SpringConfiguration{

//	@Bean
//	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
//		UserDetails admin = User.withUsername("Swamy")
//				.password(encoder.encode("swamy"))
//				.roles("ADMIN").build();
//		UserDetails user = User.withUsername("mani")
//				.password(encoder.encode("mani")).roles("USER").build();
//		return new InMemoryUserDetailsManager(admin, user);
//	}
	

	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserEntityDetailService();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		 http.csrf(CsrfConfigurer::disable)
		.authorizeHttpRequests(authorize -> authorize
		.requestMatchers("/home", "/new").permitAll()
		.anyRequest().authenticated())
		.formLogin(Customizer.withDefaults());
		return http.build();
	}
//	@Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//            .authorizeHttpRequests(authorize -> authorize
//                .requestMatchers("/home").permitAll()
//                .requestMatchers("/admin/**").hasRole("ADMIN")
//                .requestMatchers("/user/**").hasRole("USER")
//                .anyRequest().authenticated()
//            )
//            .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
//            .build();
//    }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService());
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}
}

package com.veterinaria.auth;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/api/productos").permitAll()
		.antMatchers(HttpMethod.GET, "/api/departamentos").permitAll()
		.antMatchers(HttpMethod.GET, "/api/provincias/{departamento}").permitAll()
		.antMatchers(HttpMethod.GET, "/api/distritos/{departamento}/{provincia}").permitAll()
		.antMatchers(HttpMethod.POST, "/api/cliente").permitAll()
		.antMatchers(HttpMethod.GET, "/api/usuarios").permitAll()
		.antMatchers(HttpMethod.GET, "/api/usuarios/ubigeo").permitAll()
		.antMatchers(HttpMethod.GET, "/api/productosPrecio/{precioMin}/{precioMax}").permitAll()
		.antMatchers(HttpMethod.GET, "/api/productos/marca").permitAll()
		.antMatchers(HttpMethod.GET, "/api/productos/proveedor").permitAll()
		.antMatchers(HttpMethod.GET, "/api/productos/{id}").permitAll()
		.antMatchers(HttpMethod.GET, "/servicio/servicios").permitAll()
		.antMatchers(HttpMethod.GET, "/servicio/servicios/{id}").permitAll()
		.antMatchers(HttpMethod.GET, "/servicio/servicios/categoria").permitAll()
		//+.antMatchers("/api/productos/**").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and().cors().configurationSource(corsConfigurationSource());;
	}

	
	
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowedOrigins(Arrays.asList("http://localhost:4200","https://patazas-62d1c.web.app","https://patazasvet.web.app"));
		config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		config.setAllowCredentials(true);
		config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		return source;
	}
	
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter(){
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}
}

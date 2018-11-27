package org.baeldung.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableOAuth2Sso
@Configuration
public class UiSecurityConfig extends WebSecurityConfigurerAdapter {
	@Value("${security.oauth2.client.accessTokenUri}")
	private String oauthHost;
	@Autowired
	private MyLogoutSuccessHandler logoutSuccessHandler;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/login**","/mylogoutUrl","/mylogin.html")
		.permitAll()
		.anyRequest()
				.authenticated()
				.and().logout().logoutUrl("/mylogoutUrl").logoutSuccessHandler(logoutSuccessHandler)
				.deleteCookies("JSESSIONID").permitAll()
				.and()
				.csrf().disable();
	}

}

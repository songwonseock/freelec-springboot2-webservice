package com.song.book.config.auth;

import com.song.book.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author wonseok.song
 * @since 2020-01-09
 */
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final CustomOAuth2UserService customOAuth2UserSeivice;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
          .csrf().disable()
          .headers().frameOptions().disable()
          .and()
            .authorizeRequests()
            .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()
            .antMatchers("/api/v1/**").hasRole(Role.USER.name())
            .anyRequest().authenticated()
          .and()
            .logout()
              .logoutSuccessUrl("/")
          .and()
            .oauth2Login()
              .userInfoEndpoint()
                .userService(customOAuth2UserSeivice);
  }
}

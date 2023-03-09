package com.sashika.hellosecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * Created by Sashika.Udana
 * on 09/Mar/2023
 */
@Configuration
public class Config extends WebSecurityConfigurerAdapter {
   /** @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
        userDetailsService.createUser(User.withUsername("John").password("123456").authorities("read").build());

        return userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();// treats password as plain text
    }**/

   //Instead of defining beans separately (as in above) we can do it via below method
   @Override
   protected void configure(AuthenticationManagerBuilder auth)throws Exception {
       auth.inMemoryAuthentication()
               .withUser("John")
               .password("123456")
               .authorities("read")
               .and()
               .passwordEncoder(NoOpPasswordEncoder.getInstance());
   }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.authorizeRequests()
                .anyRequest().authenticated();
    }
}

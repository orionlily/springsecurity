package com.example.demo.config;

import com.example.demo.service.SysUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author li.lc
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public SysUserService getSysUserService() {
        return new SysUserService();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        //默认
        return new MyPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       /* auth.inMemoryAuthentication()
                .withUser("admin1").password("{noop}admin123").roles("ADMIN1","USER1")
                .and()
                .withUser("user1").password("{noop}user123").roles("USER1");*/
        auth.userDetailsService(getSysUserService()).passwordEncoder(getPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/loginPage").loginProcessingUrl("/login").successHandler(customSuccessHandler()).defaultSuccessUrl("/index")
                .failureHandler(customFailureHandler())
                .usernameParameter("aa").passwordParameter("bb")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/loginPage").invalidateHttpSession(true)
                .and()
                .authorizeRequests()
                .antMatchers("/loginPage").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN1")
                .antMatchers("/user/**").hasRole("001")
                .antMatchers("/any/**").hasAnyRole("USER1", "ADMIN1")
                .anyRequest().authenticated()
                .and().httpBasic().disable().csrf().disable().rememberMe().tokenValiditySeconds(30);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .mvcMatchers("/world")
                .antMatchers("/css/**")
                .antMatchers("/js/**")
                .antMatchers("/**.ico")
        ;
    }

    @Bean
    public AuthenticationFailureHandler customFailureHandler(){
        return new Fail();
    }

    @Bean
    public AuthenticationSuccessHandler customSuccessHandler(){
        return new Succ();
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("123456"));
    }
}

package kr.btsoft.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired DataSource dataSource;

    @Autowired PasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //Database 상엔 authority 값이 "ROLE_ADMIN", "ROLE_USER" 형식으로 INSERT.
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder)
                .usersByUsernameQuery("select user_id as username, user_pw as password, enabled from user_info where user_id = ?")
                .authoritiesByUsernameQuery("select user_id as username, authority from authorities where user_id = ?");
    }

    //Spring Security 5 에선 Role 이름을 "ADMIN", "USER" 형식으로 해야 인증이 완료됨.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers("/signup").permitAll()
//                .antMatchers("/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/**").permitAll()
                .and().formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/",true)
                .permitAll()
                .and().logout()
                .logoutSuccessUrl("/login")
                .permitAll()
                .invalidateHttpSession(true)
                .and()
                .csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

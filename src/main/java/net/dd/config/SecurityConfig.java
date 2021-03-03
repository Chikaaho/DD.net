package net.dd.config;


import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http.formLogin().loginPage("/login.php");
        http.logout();
        // 保存cookie两周
        http.rememberMe();
        http.csrf().disable();
    }
}

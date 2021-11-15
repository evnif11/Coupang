package com.clonecoding.coupang.security;


import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Order(1)
@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UsernamePasswordAuthenticationProvider usernamePasswordAuthenticationProvider;

    public SecurityConfig(UsernamePasswordAuthenticationProvider usernamePasswordAuthenticationProvider) {
        this.usernamePasswordAuthenticationProvider = usernamePasswordAuthenticationProvider;
    }

    // 사용자 인증하는 방식인 authenticationProvider 담긴다 혹은 서비스
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(usernamePasswordAuthenticationProvider);
    }

    // 정적 리소스는 시큐리티 필터 통과하지 않아도 접근가능하도록 설정함
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().requestMatchers(
                PathRequest.toStaticResources().atCommonLocations()
        );
    }

    // 핵심 시큐리티 설정
    // 필터 체인에 어떤 필터들을 포함시킬 것인지 설정한다
    // antMatcher 를 통해 url 패턴에 따라 다른 필터가 적용되도록 설정할 수 있다
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(request -> {
            request
                    .antMatchers("/","/register").permitAll()
                    .anyRequest().authenticated();
        }).formLogin(login ->
                login.loginPage("/login").loginProcessingUrl("/process-login").permitAll()
                .defaultSuccessUrl("/", false)
                .failureUrl("/login-error")
        ).logout(
                logout -> logout.logoutSuccessUrl("/")
        );
    }
}

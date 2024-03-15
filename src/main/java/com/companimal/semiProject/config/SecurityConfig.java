package com.companimal.semiProject.config;

import com.companimal.semiProject.common.MemberRole;
import com.companimal.semiProject.config.handler.AuthFailHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private AuthFailHandler authFailHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(auth -> {
            auth.requestMatchers("auth/login", "contents/member/regist", "/auth/fail", "/main", "/").permitAll();
            auth.requestMatchers("/manager/*").hasAnyAuthority(MemberRole.MANAGER.getRole());
            auth.requestMatchers("creator/*").hasAnyAuthority(MemberRole.CREATOR.getRole());
            auth.anyRequest().permitAll();

        }).formLogin(login -> {
            login.loginPage("/auth/login");
            login.usernameParameter("memberId");
            login.passwordParameter("memberPwd");
            login.defaultSuccessUrl("/", true);
            login.failureHandler(authFailHandler);

            /* 메인페이지 로그아웃 버튼에  <form th:action="@{/auth/logout}" th:method="post"> 써야함*/
        }).logout(logout -> {
            logout.logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout"));
            logout.deleteCookies("JSESSIONID");
            logout.invalidateHttpSession(true);
            logout.logoutSuccessUrl("/");

        }).sessionManagement(session -> {
            session.maximumSessions(1);
            session.invalidSessionUrl("/");

        }).csrf(csrf -> csrf.disable());

        return http.build();
    }
}

package com.example.mysauna;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    // フォーム認証の設定開始
    http.formLogin(login -> login
        // ユーザー名、パスワードの送信先URL
        .loginProcessingUrl("/user/login")
        // ログイン画面のURL
        .loginPage("/user/login")
        // ユーザ名のリクエストパラメータ名を設定
        .usernameParameter("username")
        // パスワードのリクエストパラメータ名を設定
        .passwordParameter("password")
        // ログイン成功後のリダイレクト先URl
        .defaultSuccessUrl("/sauna/index")
        // ログイン失敗後のリダイレクト先URL
        .failureUrl("/user/login?error")
        // ログアウトの設定開始
        .permitAll()).logout(logout -> logout
            .logoutUrl("/user/logout")
            // ログアウト成功後のリダイレクト先URL
            .logoutSuccessUrl("/user/login"))
        // URL毎の認可設定開始
        .authorizeHttpRequests(authz -> authz
            .mvcMatchers("/sauna/new", "/sauna/create", "/sauna/index").permitAll()
            .mvcMatchers("/user/new").permitAll()
            .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
            .permitAll()
            .anyRequest().authenticated());
    return http.build();
  }

  // パスワードハッシュ化
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}

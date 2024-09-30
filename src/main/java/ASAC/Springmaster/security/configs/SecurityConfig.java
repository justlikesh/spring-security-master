package ASAC.Springmaster.security.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {  // 여기서 별도의 설정을 할수잇다

        http                                                     // 인증, 인가 정책을 설정할수잇다
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/css/**","/images/**","/js/**","/favicon.*","/*/icon-*").permitAll()
                        .requestMatchers("/","signup" +
                                "").permitAll()
                        .anyRequest().authenticated())
                .formLogin(form -> form.loginPage("/login").permitAll())
                .userDetailsService(userDetailsService)
        ;

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){    // 비밀번호를 암호화하고 검증하는 설정
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails user = User.withUsername("user")
//                .password("{noop}1111")
//                .roles("USER").build();            // 사용자 여려멍을 추가할 수 도 있다.
//
//        return new InMemoryUserDetailsManager(user);
//    }
}
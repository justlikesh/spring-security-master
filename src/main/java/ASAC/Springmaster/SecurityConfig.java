package ASAC.Springmaster;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {  // 여기서 별도의 설정을 할수잇다
        http                                                     // 인증, 인가 정책을 성정할수잇다
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())      //http 설정에대한 인가설정을 하겠다 어떤 요청에도 인증을 받겠따
                .formLogin(Customizer.withDefaults()); //인증을 받지 못햇을경우에 인증을 받도록 하는방식  디폴트방식

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user = User.withUsername("user")
                .password("{noop}1111")
                .roles("USER").build();            // 사용자 여려멍을 추가할 수 도 있다.

        return new InMemoryUserDetailsManager(user);
    }
}

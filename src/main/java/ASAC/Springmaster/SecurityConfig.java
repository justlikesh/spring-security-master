package ASAC.Springmaster;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {  // 여기서 별도의 설정을 할수잇다
        http                                                     // 인증, 인가 정책을 성정할수잇다
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())      //http 설정에대한 인가설정을 하겠다 어떤 요청에도 인증을 받겠따
                .formLogin(form -> form
//                        .loginPage("/loginPage")
                        .loginProcessingUrl("/loginProc")
                        .defaultSuccessUrl("/", true) //ture 주면 어떤 경우라도 디폴트로가고 false 면 해당 url 에 남아잇는다
                        .usernameParameter("userId")
                        .passwordParameter("passwd")
                        .successHandler((request, response, authentication) -> {     // 위에 설정보다 핸들러가 더 우선순위이다
                            System.out.println("authentication :" + authentication);
                            response.sendRedirect("/home");
                        })
                        .failureHandler((request, response, exception) -> {
                            System.out.println("exception:" + exception.getMessage());
                            response.sendRedirect("/login");
                        })
                        .permitAll()
                );

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

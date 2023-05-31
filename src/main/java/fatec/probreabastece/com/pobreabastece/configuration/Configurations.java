package fatec.probreabastece.com.pobreabastece.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Configurations {

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {

        return httpSecurity.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, "/home").permitAll()
                .requestMatchers(HttpMethod.GET, "/users").permitAll()
                .requestMatchers(HttpMethod.POST, "/users").permitAll()
                .requestMatchers(HttpMethod.PUT, "/users/**").permitAll()
                .requestMatchers(HttpMethod.DELETE, "/users/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/login").permitAll()
                .requestMatchers(HttpMethod.GET, "/login").permitAll()

                .requestMatchers(HttpMethod.GET, "/consulta").permitAll()
                .requestMatchers(HttpMethod.POST, "/cadastro").permitAll()
                .requestMatchers(HttpMethod.POST, "/postos/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/postos/**").permitAll()
                .requestMatchers(HttpMethod.DELETE, "/postos/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/endereco").permitAll()


                .requestMatchers("/h2/**").permitAll()
                .anyRequest().authenticated().and().build();




    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {

        return  authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder encoder(){
        return  new BCryptPasswordEncoder();
    }
}

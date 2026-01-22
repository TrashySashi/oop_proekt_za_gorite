@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
          .csrf().disable()
          .authorizeHttpRequests()
          .requestMatchers("/api/auth/**", "/api/podcasts").permitAll()
          .requestMatchers(HttpMethod.POST, "/api/podcasts/**").hasRole("ADMIN")
          .anyRequest().authenticated()
          .and()
          .httpBasic();

        return http.build();
    }
}

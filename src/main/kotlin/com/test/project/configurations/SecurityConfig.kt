package com.test.project.configurations

import com.test.project.components.jwt.JwtRequestFilter
import com.test.project.services.UserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

//class SomeService

@Configuration
class SecurityConfig(
    private val userService: UserService,
    private val jwtRequestFilter: JwtRequestFilter,
) {
    @Bean
    fun getEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
    @Bean
    fun configure(http: HttpSecurity) : SecurityFilterChain {
        return http.authorizeHttpRequests {
            it.requestMatchers("/api/auth/**").permitAll()
            it.requestMatchers("/api/admin/**").hasRole("ADMIN")
            it.requestMatchers("/api/**").hasAnyRole("ADMIN", "USER")
        }
            .userDetailsService(userService)
            .httpBasic(Customizer.withDefaults())
            .csrf {
                it.disable()
            }
            .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter::class.java)
            .build()
    }
//    @Bean
//    fun userDetailsService(): UserDetailsService{
//        val user: UserDetails = User.builder()
//            .username("user")
//            .password(getEncoder().encode("password"))
//            .roles("USER")
//            .build()
//        val admin: UserDetails = User.builder()
//            .username("admin")
//            .password(getEncoder().encode("secret"))
//            .roles("ADMIN")
//            .build()
//        return InMemoryUserDetailsManager(user, admin)
//    }
//    @Bean
//    fun configure(http: HttpSecurity): SecurityFilterChain{
//        http.authorizeHttpRequests{requests ->
//            requests.requestMatchers("css/**").permitAll()
//            requests.requestMatchers("js/**").permitAll()
//            requests.requestMatchers("admin/**").hasRole("ADMIN")
//            requests.anyRequest().authenticated()
//        }
//        http.httpBasic(Customizer.withDefaults())
//        return http.build()
//    }
}
//• permitAll() - указывает, что любой может получить доступ к URL (аутентифицированные
//и не аутентифицированные пользователи).
//• denyAll() - указывает, что никто не может получить доступ к URL.
//• authenticated() - указывает, что любой аутентифицированный пользователь может
//получить доступ к URL.
//• hasRole(String role) - ярлык для указания URL-адресов, требующих определенной
//роли. Не должно начинаться с ROLE_, так как оно вставляется автоматически.
//• hasAnyRole(String... roles) - аналогично предыдущему методу, но позволяет указать
//несколько ролей.
//• hasAuthority(String authority) - указывает, что доступ к URL требует определенных
//полномочий. Мы также можем использовать этот метод для указания роли, но он
//должен иметь префикс ROLE_. То есть hasAuthority("ROLE_ADMIN") аналогичен
//hasRole("ADMIN").
//• hasAnyAuthority(String... authorities) - аналогичен предыдущему методу, но позволяет
//указать несколько полномочий (или ролей).
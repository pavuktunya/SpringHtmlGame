package com.test.project.configurations

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

class SomeService

@Configuration
class CustomConfig {
    @Bean
    fun getCustomBean() = SomeService()
    @Bean
    fun getEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
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
    @Bean
    fun configure(http: HttpSecurity): SecurityFilterChain{
        http.authorizeHttpRequests{requests ->
            requests.requestMatchers("admin/**").hasRole("ADMIN")
            requests.anyRequest().authenticated()
        }
        http.httpBasic(Customizer.withDefaults())
        return http.build()
    }
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
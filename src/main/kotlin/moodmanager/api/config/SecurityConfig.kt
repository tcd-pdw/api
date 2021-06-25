package moodmanager.api.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder


@Configuration
class SecurityConfig: WebSecurityConfigurerAdapter () {

    @Bean
    fun encoder (): PasswordEncoder {
        return BCryptPasswordEncoder ()
    }

    override fun configure(security: HttpSecurity) {
        security.httpBasic().disable()
        security.csrf().disable()
    }

}
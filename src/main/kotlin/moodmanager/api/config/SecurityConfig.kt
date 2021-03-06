package moodmanager.api.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import javax.sql.DataSource


@Configuration
@EnableWebSecurity
class SecurityConfig: WebSecurityConfigurerAdapter () {

    @Bean
    fun encoder (): PasswordEncoder {
        return BCryptPasswordEncoder ()
    }

    override fun configure(security: HttpSecurity) {
        security.httpBasic()
        security.csrf().disable()
    }

//    override fun configure(http: HttpSecurity) {
//        http.csrf().disable().authorizeRequests()
//            .antMatchers(HttpMethod.POST,"/signup").permitAll()
//            .anyRequest().authenticated()
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//    }
//
//    override fun configure(auth: AuthenticationManagerBuilder) {
//        auth.userDetailsService(userDetailsService).passwordEncoder(encoder())
//    }

//    @Autowired
//    lateinit var dataSource: DataSource
//
//    @Autowired
//    fun configAuthentication(auth: AuthenticationManagerBuilder){
//        auth.jdbcAuthentication().dataSource(dataSource)
//            .usersByUsernameQuery("select username,password, enabled from users where username=?")
//            .authoritiesByUsernameQuery("select username, role from user_roles where username=?")
//    }
//
//    override fun configure(http: HttpSecurity){
//        http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/admin").hasRole("ADMIN")
//            .anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and().logout()
//            .permitAll()
//
//        http.exceptionHandling().accessDeniedPage("/403")
//    }
}

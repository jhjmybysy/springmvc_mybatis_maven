package cn.transfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/signup", "/about").permitAll()
				// #4 任何人(包括没有经过验证的)都可以访问”/signup”和”/about”
				.antMatchers("/users/**").hasRole("USER")
				// #6 /users/”开头的URL必须要是USER用户，譬如”user”用户
				.anyRequest().authenticated()
				// #7 所有其他的URL都需要用户进行验证
				.and().formLogin()
				// #8 使用Java配置默认值设置了基于表单的验证。使用POST提交到”/login”时，需要用”username”和”password”进行验证。
				.loginPage("/login")
				// #9 注明了登陆页面，意味着用GET访问”/login”时，显示登陆页面
				.permitAll();
		// #5
		// 任何人(包括没有经过验证的)都可以访问”/login”和”/login?error”。permitAll()是指用户可以访问formLogin()相关的任何URL。
		/*
		 * http.authorizeRequests().antMatchers("/").permitAll().anyRequest()
		 * .authenticated().and().formLogin().loginPage("/login")
		 * .permitAll().and().logout().permitAll();
		 */
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
		// #3 忽略任何以”/resources/”开头的请求，这和在XML配置http@security=none的效果一样

	}

	@Autowired
	public void registerAuthentication(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("user")
		// #1 可以在内存中的验证(memory authentication)叫作”user”的用户
				.password("password").roles("USER").and().withUser("admin")
				// #2 可以在内存中的验证(memory authentication)叫作”admin”的管理员用户
				.password("password").roles("ADMIN", "USER");
		/*
		 * auth .inMemoryAuthentication()
		 * .withUser("user").password("password").roles("USER");
		 */
	}
}

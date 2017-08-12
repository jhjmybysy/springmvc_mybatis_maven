package cn.transfer.service;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.transfer.model.User;
import cn.transfer.service.UserService;

public class UserServiceTest {

	@Test
	public void testFindUsersById() throws Exception {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
				"classpath*:spring/applicationContext-*.xml");
		UserService service = (UserService) classPathXmlApplicationContext
				.getBean("userService");
		User user = service.findUserById(3);
		System.out.println(user.getAge());
	}

}

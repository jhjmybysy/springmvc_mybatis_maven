package cn.transfer.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.transfer.mapper.UserMapper;
import cn.transfer.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-*.xml")
public class UserMapperTest {

	
	@Autowired
	UserMapper userMapper;
	
	@Test
	public void testSelectByPrimaryKey() {
		User user= userMapper.selectByPrimaryKey(3);
		System.out.println(user.getAge());
	}

}

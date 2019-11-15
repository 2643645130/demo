package com.demo;

import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.dao.UserMapperDao;
import com.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {
	@Autowired
	UserMapperDao userMapper;
	
	/*@Test
	public void addUserTest() throws Exception{
		
		User user = new User();
		user.setId(1);
		user.setName("y");
		user.setAge(24);
		
		userMapper.addUser(user);
		
		
	}
	@Test
	public void contextLoads() {
//		User user = new User();
	    List<User> list = userMapper.queryAllUser();
		
	    for (User user : list) {
	    	System.out.println(user);
		}
		
		
	}
	@Test
	public void deleteUserTest() throws Exception{
		
		
		userMapper.deleteUser(4);
		List<User> list = userMapper.queryAllUser();
		
	    for (User user : list) {
	    	System.out.println(user);
		}
	}
	@Test
	public void UpdateUserTest() throws Exception{
		
		User user = new User();
		user.setId(3);
		user.setName("sjc");
		user.setAge(20);
		
		userMapper.updateUser(user);
		
	}*/
	/*//一对多测试方法	
	@Test
	public void UserWithAccountResultTest() {
		
		List<User> user = userMapper.findUserWithAccount(2);
		System.out.println(user);
	}*/
	
	@Test
	public void findUserTest() {
	    List<User> list = userMapper.findUserWithProduct(1);
	}
}

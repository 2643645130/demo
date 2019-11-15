package com.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.dao.UserMapperDao;
import com.demo.server.AccountDao;
import com.demo.server.Accountserice;
import com.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	UserMapperDao userMapper;
	@Autowired
	AccountDao ad;
	@Autowired
	Accountserice as;
	@Test
	public void contextLoads() {
		User user = new User();
	    List<User> list = userMapper.queryAllUser();
		
		System.out.println(list);
		
	}
	@Test
	public void account(){
		try { //try catch是为了能够继续运行transfer2方法
			System.out.println("begin transfer");
			ad.updateAccountIn("yx",200);
			System.out.println("transfer end");
		} catch (Exception e) {
		}
 
		System.out.println("begin transfer2");
		ad.updateAccountIn("yx",200.);
		System.out.println("transfer2 end");
	}

	
	@Test
	public void yangxin() {
		as.tran("yx", 2000);
	}
}
	


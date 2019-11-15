package com.demo.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.UserMapperDao;
import com.entity.Page;
import com.entity.User;

@Service
public class UserDaoService {
	
	@Autowired
	UserMapperDao userMapperDao;
	
	
 
	public Page<User> selectOnePage(Integer pageNum, Integer pageSize) {
		int totalRecord = userMapperDao.getTotalRecord();// 获取总数据条数
		Page<User> page = new Page<User>(pageNum, pageSize, totalRecord);// 创建Page对象
		page.setList(userMapperDao.selectUsersPage(page.startIndex, pageSize));// 获取当前页信息
		return page;
	}

}

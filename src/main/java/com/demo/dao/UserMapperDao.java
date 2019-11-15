package com.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.entity.User;

@Mapper
public interface UserMapperDao {

	int addUser(User u);
	 
	int deleteUser(int id);
 
	User selectOneUser(int id);
 
//  List<User> selectAllUser();
	
	Integer getTotalRecord();// 查询数据库中总数据条数
	 
	List<User> selectUsersPage(Integer pageNum, Integer pageSize);// 查询当前页的数据


}

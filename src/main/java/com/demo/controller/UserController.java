package com.demo.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.dao.UserMapperDao;
import com.demo.server.UserDaoService;
import com.entity.Page;
import com.entity.User;

@Controller
@RequestMapping("user")
public class UserController {
	//自动注入Dao，用来实现数据库的相关操作
		@Autowired
		UserDaoService userDaoService;
		
		@Autowired
		UserMapperDao userMapperDao;
		
		//网站的映射，创建相关的空的映射，实现网站的跳转
		@RequestMapping("/selectOne")
		public String selectOne() {
			return "selectOne";
		}
	 
		@RequestMapping("/addUser")
		public String addUser() {
			return "addUser";
		}
	 
		@RequestMapping("/delete")
		public String deleteOne() {
			return "delete";
		}
		
		//实现查询所有用户的操作
		/*@RequestMapping("/index")
		public String seletAll(Model model) {
			List<User> list = userMapperDao.selectAllUser();
			model.addAttribute("list", list);//使用model保存，与前台进行交互
			return "index";
		}*/
	 
		//实现查询某个用户
		@RequestMapping("/selectOneUserPage")
		public String seletOnePage(HttpServletRequest request, Model model) {
			int id = Integer.parseInt(request.getParameter("id"));
			User list = userMapperDao.selectOneUser(id);
			model.addAttribute("list", list);
			return "selectOne";
		}
		
		// 实现查询用户的操作
		@RequestMapping("/index")
		public String seletAll(Model model) {
			int pageSize = 5;// 设置访问条数
			Page<User> page = userDaoService.selectOnePage(1, pageSize);// 首次访问，默认访问第一页，所有传1,
			model.addAttribute("page", page);
			return "index";
		}
	 
		@RequestMapping("/selectPage")
		public String seletPage(Model model, Integer pageNum) {// 通过数据绑定，实现前台与后台的数据交互
			int pageSize = 5;
			Page<User> page = userDaoService.selectOnePage(pageNum, pageSize);// 根据pageNum传的参数，实现对应页面的访问
			model.addAttribute("page", page);
			return "index";
		}

		
		//实现添加用户操作
		@RequestMapping("/addUserPage")
		public String addUserPages(HttpServletRequest request, Model model) {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			int age = Integer.parseInt(request.getParameter("age"));
			User user = new User(name, password, age);
			int n = userMapperDao.addUser(user);
			if (n > 0)
				model.addAttribute("message","添加成功");
			else
				model.addAttribute("message","添加失败");
			return "message";//此处返回到消息控制页面
		}
		
		//实现删除用户操作
		@RequestMapping("/deletePage")
		public String deleteOnePages(HttpServletRequest request, Model model) {
			int id = Integer.parseInt(request.getParameter("id"));
			int n = userMapperDao.deleteUser(id);
			if (n > 0)
				model.addAttribute("message","删除成功");
			else
				model.addAttribute("message","删除失败");
			return "message";
		}
		
		
		
}

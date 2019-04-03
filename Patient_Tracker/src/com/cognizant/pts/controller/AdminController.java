package com.cognizant.pts.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

//import com.cognizant.pts.entity.Admin;
import com.cognizant.pts.model.AdminModel;
import com.cognizant.pts.service.AdminService;
import com.cognizant.pts.validation.AdminValidator;

@SessionAttributes("genderList")
@Controller
public class AdminController {

	@Autowired
	private AdminValidator adminValidator;
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="index.htm",method=RequestMethod.GET)
	public String loadLoginForm()
	{
		return "home";
	}
	
	@RequestMapping(value="logout.htm",method=RequestMethod.POST)
	public String loadHomePage()
	{
		return "home";
	}

	@RequestMapping(value="doLogin.htm",method=RequestMethod.POST)
	public ModelAndView doLogin(@ModelAttribute("admin")AdminModel adminModel,Errors error)
	{
		ModelAndView mv=new ModelAndView();
		ValidationUtils.invokeValidator(adminValidator, adminModel, error);
		if(error.hasErrors())
		{
			mv.setViewName("home");
		}
		else{
		int checkAdminLogin=adminService.doLogin(adminModel);
		if(checkAdminLogin==3)
		{	
			mv.addObject("status","login Successful");
			mv.setViewName("afterlogin");
		}
		else
		{
			mv.addObject("status","login Denied");
			mv.setViewName("home");
		}
		}
		return mv;
	}
	
	@ModelAttribute("adminModel")
	public AdminModel creatAdminObject()
	{
		AdminModel adminModel=new AdminModel();
		return adminModel;
	}
	
	@RequestMapping(value="adminregistration.htm",method=RequestMethod.POST)
	public ModelAndView loadAdminRegistrationForm()
	{
		ModelAndView mv=new ModelAndView();
		List<String> genderList=new ArrayList<>();
		genderList.add("Male");
		genderList.add("Female");
		genderList.add("Trans Gender");
		mv.addObject("genderList", genderList);
		mv.setViewName("addadmin");
		return mv; 
	}
	
	
	
	@RequestMapping(value="addadmin.htm",method=RequestMethod.POST)
	public ModelAndView persistAdmin(@ModelAttribute("adminregModel")AdminModel adminreg)
	{
		
		ModelAndView mv=new ModelAndView();
		
		boolean adminPersist=adminService.addAdmin(adminreg);
		if(adminPersist)
		{
			mv.addObject("status","Registration Successful");
			mv.setViewName("addadmin");
		}
		else
		{
			mv.addObject("status","Registration Failed");
			mv.setViewName("addadmin");
		}
		return mv;
	}
	
	@ModelAttribute("adminregModel")
	public AdminModel creatAdminRegistrationObject()
	{
		AdminModel adminregModel=new AdminModel();
		return adminregModel;
	}
	
	@RequestMapping(value="login.htm" ,method=RequestMethod.POST)
	public String loadLoginFormAfterRegistration()
	{
	return "home";
		
	}

}

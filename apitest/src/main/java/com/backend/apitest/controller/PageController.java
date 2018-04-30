package com.backend.apitest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


/**
 * 
 * @author saddam
 *
 */
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@Controller
@EnableWebMvc

public class PageController {
	
	 private static final Logger logger = LoggerFactory.getLogger(PageController.class);
		
	  
	
//	@Autowired
//	public UserDAO userDAO;

	//This is for home page 
	
	@RequestMapping(value = {"/home", "/index" })
	public ModelAndView index() {
		logger.info("This is the PageController ");

	//	ModelAndView mv = new ModelAndView("page");
		ModelAndView mv = new ModelAndView("page");
		//mv.addObject("greeting", "      Welcome to Spring And Hibernate World ");
		return mv;
	}
	@RequestMapping(value = {"/userlogin" })
	public ModelAndView LoginPage() {
		logger.info("This is the PageController ");

	//	ModelAndView mv = new ModelAndView("page");
		ModelAndView mv = new ModelAndView("welCome");
		//mv.addObject("greeting", "      Welcome to Spring And Hibernate World ");
		return mv;
	}
	@RequestMapping(value = {"/e_home" })
	public ModelAndView E_HomePage() {
		logger.info("This is the PageController ");

	//	ModelAndView mv = new ModelAndView("page");
		ModelAndView mv = new ModelAndView("ShoppingHome");
		//mv.addObject("greeting", "      Welcome to Spring And Hibernate World ");
		return mv;
	}
	
//	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
//	public ModelAndView welcomePage() {
//
//		ModelAndView model = new ModelAndView();
//		model.addObject("title", "Spring Security Hello World");
//		model.addObject("message", "This is welcome page!");
//		model.setViewName("hello");
//		return model;
//
//	}
//
//	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
//	public ModelAndView adminPage() {
//
//		ModelAndView model = new ModelAndView();
//		model.addObject("title", "Spring Security Hello World");
//		model.addObject("message", "This is protected page - Admin Page!");
//		model.setViewName("admin");
//
//		return model;
//
//	}
//
//	@RequestMapping(value = "/dba**", method = RequestMethod.GET)
//	public ModelAndView dbaPage() {
//
//		ModelAndView model = new ModelAndView();
//		model.addObject("title", "Spring Security Hello World");
//		model.addObject("message", "This is protected page - Database Page!");
//		model.setViewName("admin");
//
//		return model;
//
//	}
	
	/*@RequestMapping(value = "/register", method = RequestMethod.GET)
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("register");
	   mav.addObject("user", new User());
	    return mav;
	  }*/
	/*
	 @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("user") User user) {
	  userDao.register(user);
	  return new ModelAndView("welcome", "firstname", user.getFirstname());
	  }*/



}

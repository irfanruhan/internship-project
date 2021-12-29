package com.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("hello")
public class BasicController {
	@RequestMapping(method = RequestMethod.GET)
	public void sayHello() {
		System.out.println("Welcome to Spring MVC.............");
	}
	
	@RequestMapping(value="hello2", method = RequestMethod.GET)
	public String sayHello2() {
		System.out.println("sayhello2 method is called.............");
		return "welcome";
	}
	@RequestMapping(value="hello3", method = RequestMethod.GET)
	public ModelAndView sayHello3() {
		ModelAndView mandv=new ModelAndView();
		mandv.addObject("mykey", "Welcome to Spring MVC3............");
		mandv.setViewName("welcome");
		return mandv;
	}
	@RequestMapping(value="hello4", method = RequestMethod.GET)
	public ModelAndView sayHello4(ModelAndView mandv) {
		mandv.addObject("mykey", "Welcome to Spring MVC3.....from injected object.......");
		mandv.setViewName("welcome");
		return mandv;
	}
	@RequestMapping(value="hello5", method = RequestMethod.GET)
	public ModelAndView sayHello5(ModelAndView mandv,HttpServletRequest request) {
		mandv.addObject("mykey", "Welcome to Spring MVC3.....from injected object.......");
		mandv.setViewName("welcome");
		//HttpSession session=request.getSession();
		request.setAttribute("hello", "hello world hello world hello world...");		
		return mandv;
	}
	@RequestMapping(value="hello6/{name}", method = RequestMethod.GET)
	public ModelAndView sayHello6(@PathVariable String name,ModelAndView mandv,HttpServletRequest request) {
		mandv.addObject("mykey", name);
		mandv.setViewName("welcome");
		//HttpSession session=request.getSession();
		request.setAttribute("hello", "hello world hello world hello world...");		
		return mandv;
	}
	
}

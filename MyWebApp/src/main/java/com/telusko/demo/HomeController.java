package com.telusko.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public ModelAndView home(Alien alean) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("obj", alean);
		mv.setViewName("home");
		return mv;
	}

}

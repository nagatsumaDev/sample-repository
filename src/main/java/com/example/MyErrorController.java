package com.example;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/error")
public class MyErrorController implements ErrorController {

	 @RequestMapping
	  public ModelAndView error(HttpServletRequest req, ModelAndView mav) {

	    // どのエラーでも 404 Not Found にする
	    mav.setStatus(HttpStatus.NOT_FOUND);
	    mav.setViewName("error");

	    return mav;
	  }
}

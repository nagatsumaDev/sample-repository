package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	 
    @GetMapping("/regist")
    public ModelAndView regist() {
    	ModelAndView view = new ModelAndView();
    	view.setViewName("regist.html");
        return view;
    }

    @PostMapping("/update")
    public ModelAndView update(HttpServletRequest rquest) {
    	
    	String userId = rquest.getParameter("userId");
       	String password = rquest.getParameter("password");
       	String userName = rquest.getParameter("userName");
       	
       	updateMUser(userId, password, userName);
       	
    	ModelAndView view = new ModelAndView();
    	view.addObject("userId", userId);
    	view.addObject("userName", userName);
    	view.setViewName("registed.html");
    	
		return view;
	}
    private void updateMUser(String userId, String password, String userName) {
    	// 更新
    	jdbcTemplate.update(
    		    "INSERT INTO m_user (user_id, password, user_name) VALUES (?,?,?)",
    		    userId, password, userName);
    }
    
//    private void getData() {
//    	// 1件取得
//       	//MUser mUser = jdbcTemplate.queryForObject("select * from m_user", new DataClassRowMapper<>(MUser.class));
//    	List<MUser> mUser = jdbcTemplate.query("select * from m_user", new DataClassRowMapper<>(MUser.class));
//    	System.out.println(mUser.size());
//    }
    
}
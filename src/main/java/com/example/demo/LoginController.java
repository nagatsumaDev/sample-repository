package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.MUser;
import com.example.entity.TMemo;
import com.example.service.MemoService;
import com.example.service.UserService;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/memo")
public class LoginController {
	
//	@Autowired
//	private JdbcTemplate jdbcTemplate;

	@Autowired
	private UserService userService;
	

	@Autowired
	private MemoService memoService;
	
    @GetMapping("")
    public ModelAndView index() {
    	ModelAndView view = new ModelAndView();
    	view.setViewName("login.html");
        return view;
    }
    
    @PostMapping("/login")
    public ModelAndView login(HttpServletRequest rquest) {
    	
    	// 画面からuserIdとpasswordを取得
    	String userId = rquest.getParameter("userId");
        String password = rquest.getParameter("password");
       	
        MUser mUser = loginCheck(userId, password);
        
       	if (mUser != null) {
       		// 一致するユーザがいる場合
       		
       		List<TMemo> memoList = memoService.fineByUserId(userId);
       		
   			for (int i = 1; i <= 3; i ++) {
   				if (memoList.size() < i) {
   					memoList.add(new TMemo(i));
   				}
   			}
       		
       	   	ModelAndView view = new ModelAndView();
       	   	view.addObject("memoList", memoList);
        	view.addObject("userId", userId);
        	view.addObject("userName", mUser.getUserName());
        	view.setViewName("memo.html");
        	return view;
        } else {
        	// 一致するユーザがいない場合
       	   	ModelAndView view = new ModelAndView();
        	view.addObject("userId", userId);
        	view.addObject("message", "IDまたはパスワードが異なります。");
        	view.setViewName("login.html");
        	return view;
        }
    }
	
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
       	
       	if (StringUtils.isBlank(userId) || StringUtils.isBlank(password) || StringUtils.isBlank(userName)) {
           	ModelAndView view = new ModelAndView();
        	view.addObject("userId", userId);
        	view.addObject("userName", userName);
        	view.addObject("message", "未入力の項目があります。");
        	view.setViewName("regist.html");
        	return view;
       	}
       	
       	if (userId.length() < 4 || password.length() < 4) {
           	ModelAndView view = new ModelAndView();
        	view.addObject("userId", userId);
        	view.addObject("userName", userName);
        	view.addObject("message", "ユーザID、パスワードは4文字以上入力してください。");
        	view.setViewName("regist.html");
        	return view;
        }
       	
       	
       	if (userService.findByUserId(userId) != null) {
          	ModelAndView view = new ModelAndView();
        	view.addObject("userId", userId);
        	view.addObject("userName", userName);
        	view.addObject("message", "このuserIdは既に登録されています。");
        	view.setViewName("regist.html");
        	return view;
       	}
       	
       	updateMUser(userId, password, userName);
       	
    	ModelAndView view = new ModelAndView();
    	view.addObject("userId", userId);
    	view.addObject("userName", userName);
    	view.setViewName("registed.html");
    	
		return view;
	}
    
    private void updateMUser(String userId, String password, String userName) {
//    	List<MUser> mUserList = userService.findAll();
    	
    	MUser mUser = new MUser(userId, password, userName);
    	
    	userService.update(mUser);
    }
    
    
    private MUser loginCheck(String userId, String password) {
    	MUser mUser = userService.findByUserId(userId);
    	if (mUser != null) {
    		if (mUser.getPassword().equals(password)) {
    			return mUser;
    		}
    	}
    	return null;
    }
    
    
}
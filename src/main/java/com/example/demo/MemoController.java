package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.TMemo;
import com.example.service.MemoService;

import jakarta.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/memo")
public class MemoController {

	@Autowired
	private MemoService memoService;
	
    @PostMapping("/memoUpdate")
    public ModelAndView index(HttpServletRequest rquest) {
    	
       	String userId = rquest.getParameter("userId");
       	Integer memoId = Integer.valueOf(rquest.getParameter("memoId"));
      	String title = rquest.getParameter("title");
      	String text = rquest.getParameter("text");
      	  
      	TMemo tMemo = new TMemo();
      	tMemo.setUserId(userId);
      	tMemo.setMemoId(memoId);
      	tMemo.setTitle(title);
      	tMemo.setText(text);
      	
      	memoService.update(tMemo);
      	
   		List<TMemo> memoList = memoService.fineByUserId(userId);
       	
		for (int i = 1; i <= 3; i ++) {
			if (memoList.size() < i) {
				memoList.add(new TMemo(i));
			}
		}
   		
   	   	ModelAndView view = new ModelAndView();
   	   	view.addObject("memoList", memoList);
    	view.addObject("userId", userId);
    	view.addObject("userName", ""); //TODO
    	view.addObject("beforeMemoId", memoId);
    	view.setViewName("memo.html");
    	return view;
    }
    
    
}
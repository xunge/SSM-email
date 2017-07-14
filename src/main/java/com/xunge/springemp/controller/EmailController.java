package com.xunge.springemp.controller;

import javax.servlet.http.HttpSession;

import com.xunge.springemp.pojo.Msg;
import com.xunge.springemp.service.IMsgService;
import com.xunge.springemp.util.EmailUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class EmailController {
	private static final Logger logger = LoggerFactory.getLogger(EmailController.class);
	
	@Autowired
	IMsgService msgService;
	@Autowired
	EmailUtil sendMail;
	
	@RequestMapping("/index.html")
	public String loginasdf(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("welcome");
		logger.info("进入首页");
		
		return "welcome";
	}
	
	@RequestMapping("/send")
	@Transactional
	public ModelAndView sendMail(Msg msg, HttpSession session) throws Exception {
		ModelAndView modelAndView = new ModelAndView("welcome");
		modelAndView.addObject("sendto", msg.getSendto());
		modelAndView.addObject("content", msg.getContent());
		

		if(msg.getContent().trim().length()==0||msg.getSendto().trim().length()==0){
			modelAndView.addObject("info", "邮箱或者内容不能为空");
		}else {
			msgService.add(msg);
			sendMail.sendMail(msg.getSendto(), msg.getContent());
		}
		return modelAndView;
	}

}

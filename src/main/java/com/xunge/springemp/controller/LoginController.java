package com.xunge.springemp.controller;


import javax.servlet.http.HttpServletRequest;

import com.octo.captcha.service.image.ImageCaptchaService;
import com.xunge.springemp.service.impl.CustomGenericManageableCaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.xunge.springemp.pojo.User;
import com.xunge.springemp.service.IUserService;

@Controller
@SessionAttributes("username")
public class LoginController {
	
	@Autowired
	private IUserService userService;

	@Autowired
	private ImageCaptchaService imageCaptchaService;

	@Autowired
	private CustomGenericManageableCaptchaService customGenericManageableCaptchaService;


	/**
	 * 跳转到登录界面
	 * @return
	 */
	@RequestMapping("login")
	public ModelAndView login(){
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	/**
	 * 跳转到注册界面
	 * @return
	 */
	@RequestMapping("register")
	public ModelAndView register(){
		ModelAndView mv = new ModelAndView("register");
		return mv;
	}


	@RequestMapping("welcome")
	public ModelAndView welcome(){
		ModelAndView mv = new ModelAndView("welcome");
		return mv;
	}

	/**
	 * 添加用户
	 * @param user
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("userAdd")
	public ModelAndView userAdd(User user, HttpServletRequest request) throws Exception {
		String email = user.getEmail();
		String username = user.getUsername();
		String password = user.getPassword();

		System.out.println(email+"**********************");
		System.out.println(username+"**********************");
		System.out.println(password+"**********************");


		userService.register(email, username, password);
		customGenericManageableCaptchaService.removeCaptcha(request.getSession().getId());

		ModelAndView mv = new ModelAndView("active");
		mv.addObject("username", username);
		return mv;
	}

	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("personal")
	public ModelAndView personal(String username,String password) throws Exception{
		if(userService.login(username, password)) {
			if (userService.checkState(username)) {
				ModelAndView mv = new ModelAndView("personal");
				mv.addObject("username", username);
				return mv;
			} else {
				ModelAndView mv = new ModelAndView("active");
				mv.addObject("username", username);
				return mv;
			}
		}else{
			ModelAndView mv = new ModelAndView("login");
			mv.addObject("msg", "用户名或者密码错误");
			return mv;
		}
	}

	/**
	 * AJAX 检查email是否存在
	 * @param email
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/checkEmail")
	public @ResponseBody int checkEmail(String email) throws Exception {
		return userService.checkEmailExist(email);
	}

	/**
	 * AJAX 检查username是否存在
	 * @param username
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/checkUser")
	public @ResponseBody int checkUser(String username) throws Exception {
		return userService.checkUserExist(username);
	}

	/**
	 * AJAX 检查验证码是否正确
	 * @param captcha
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/checkCaptcha")
	public @ResponseBody int checkCaptcha(String captcha, HttpServletRequest request) throws Exception {
		Boolean isResponseCorrect = imageCaptchaService.validateResponseForID(request.getSession().getId(), captcha);

		if (isResponseCorrect == false) {
			return 0;
		} else {
			return 1;
		}
	}

	/**
	 * 激活用户
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/active")
	public ModelAndView active(String code) throws Exception {

		userService.activeUser(code);
		ModelAndView mv = new ModelAndView("personal");
		return mv;
	}
}

package kr.btsoft.controller;

import kr.btsoft.vo.UserDetailsVo;
import kr.btsoft.service.UserService;
import kr.btsoft.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private UserService userService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		logger.info("Welcome home! The client locale is {}.", locale);

		System.out.println(userService.testNow());

		return "login/login";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(UserVo userVo) {

		logger.info("signup request : " + userVo.toString());

		int check = userService.insrtSignup(userVo);

		return "redirect:/login";

	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@AuthenticationPrincipal UserDetailsVo userDetailsVo, Model model) {

		if(userDetailsVo != null) {

			model.addAttribute("logged", userDetailsVo.getIp());

		}

		return "home";
	}

	@PostMapping(value = "/regcheck")
	@ResponseBody
	public String regcheck(String value) {

		String success = "";
		UserVo userVo = userService.selectUser(value);

		if(userVo == null) {
			success = "0";
		} else {
			success = "1";
		}
		return success;
	}
	
	@RequestMapping(value = "/userInfoManage", method = RequestMethod.GET)
	public String userInfoMange(@AuthenticationPrincipal UserDetailsVo userDetailsVo, Model model) {

		logger.info("userInfoManage");

		return "userInfoManage";
	}


}

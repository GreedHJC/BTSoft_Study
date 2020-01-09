package kr.btsoft.controller;

import kr.btsoft.service.UserService;
import kr.btsoft.vo.UserDetailsVo;
import kr.btsoft.vo.UserVo;
import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
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
@Log4j
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		logger.info("Welcome home! The client locale is {}.", locale);

		return "login/login";

	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signUp(UserVo userVo) {

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
	public String regCheck(String userid) {

		String success = "";
		UserVo userVo = userService.selectUser(userid);

		if(userVo == null) {
			success = "0";
		} else {
			success = "1";
		}
		return success;

	}

	//produces server 로 한글 전송 시 작성
	@PostMapping(value = "/logincheck", produces = "apllication/text; charset=utf8")
	@ResponseBody
	public String loginCheck(String userid, String userpw) {

		String success = "";
		UserVo userVo = userService.selectUser(userid);

		if(userVo == null || !passwordEncoder.matches(userpw, userVo.getUserPw())) {
			success = "아이디 또는 비밀번호가 틀립니다.";
		} else if(userVo != null && userVo.isEnabled() == false){
			success = "인증 미완료 계정입니다. 관리자에게 문의하세요.";
		}else {
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

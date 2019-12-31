package kr.btsoft.controller;

import kr.btsoft.dto.TestDto;
import kr.btsoft.service.TestService;
import kr.btsoft.vo.TestVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.Locale;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private TestService testService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		logger.info("Welcome home! The client locale is {}.", locale);

		System.out.println(testService.testNow());

		return "login/login";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(TestVo testVo) {

		logger.info("signup request : " + testVo.toString());

		int check = testService.insrtSignup(testVo);

		return "redirect:/login";

	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@AuthenticationPrincipal TestDto testDto, Model model) {

		if(testDto != null) {

			model.addAttribute("logged", testDto.getIp());

		}

		return "home";
	}

}

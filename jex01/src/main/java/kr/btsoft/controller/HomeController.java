package kr.btsoft.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.btsoft.dto.TestDto;
import kr.btsoft.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
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
	private TestService testService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		System.out.println(testService.testNow());

		return "login/login";
	}

	@ResponseBody
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(@RequestBody TestDto testDto) {

		logger.info("signup request : " + testDto.toString());

		return "success";

	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {

	    return "home";
    }
	
}

package kr.btsoft.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BreakController {
	private static final Logger logger = LoggerFactory.getLogger(BreakController.class);
	
	@RequestMapping(value = "/breakManage")	//, method = RequestMethod.POST
	public String breakManage() {
		return "break/breakManage";
	}
	
	@RequestMapping(value = "/breakApply")	//, method = RequestMethod.POST
	public String breakApply() {
		return "break/breakApply";
	}
}

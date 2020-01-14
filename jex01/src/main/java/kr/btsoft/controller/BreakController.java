package kr.btsoft.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.btsoft.service.BreakService;
import kr.btsoft.vo.UserDetailsVo;

@Controller
public class BreakController {
	private static final Logger logger = LoggerFactory.getLogger(BreakController.class);
	
	@Autowired
	private BreakService breakService;
	
	@RequestMapping(value = "/breakManage")	//, method = RequestMethod.POST
	public ModelAndView breakManage(@AuthenticationPrincipal UserDetailsVo userDetailsVo,HttpServletRequest request) throws JsonProcessingException {
		ModelAndView mv = new ModelAndView();
		
		List<Map<String,Object>> list = breakService.selectUserBreak(userDetailsVo.getOfficeNum());
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(list);
		
		mv.setViewName("break/breakManage");
		mv.addObject("resultMap", jsonString);
		
		return mv;
	}
	
	@RequestMapping(value = "/breakApply")	//, method = RequestMethod.POST
	public ModelAndView breakApply(@AuthenticationPrincipal UserDetailsVo userDetailsVo) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("break/breakApply");
		return mv;
	}
	
}

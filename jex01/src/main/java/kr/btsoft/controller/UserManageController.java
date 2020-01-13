package kr.btsoft.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.btsoft.service.UserService;
import kr.btsoft.vo.UserDetailsVo;
import kr.btsoft.vo.UserVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserManageController {

	private static final Logger logger = LoggerFactory.getLogger(UserManageController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/userInfoManage", method = RequestMethod.GET)
	public String userInfoMange(Model model) {

		logger.info("userInfoManage");

		return "userManage/userInfoManage";
	}
	
	@RequestMapping(value = "/userDetailInfo", method = RequestMethod.POST)
	public String userDetailInfo(Model model, @RequestParam("userData") String userData) throws ParseException {

		logger.info("userDetailInfo");

		JSONParser parser = new JSONParser();
		JSONObject jsonObj = new JSONObject();
		jsonObj = (JSONObject) parser.parse(userData);
		
		model.addAttribute("userData",jsonObj);

		return "userManage/userDetailInfo";
	}
	
	@PostMapping(value = "/selectUsersInfo")
	@ResponseBody
	public JSONArray selectUsersInfo(@RequestParam("keyword") String keyword) {

		List<UserVo> userList = userService.selectUsersInfo(keyword);
		JSONArray jsonArr = new JSONArray();
		
		try {
			for( UserVo userInfo : userList) {
				JSONObject jsonObj = new JSONObject();
				
				jsonObj.put("USERID", userInfo.getUserId());
				jsonObj.put("GRADE", userInfo.getGrade());
				jsonObj.put("JOINDAY", userInfo.getJoinDay());
				jsonObj.put("OFFICENUM", userInfo.getOfficeNum());
				jsonObj.put("OFFICETEL", userInfo.getOfficeTel());
				jsonObj.put("OUTDAY", userInfo.getOutDay());
				jsonObj.put("USERADDR", userInfo.getUserAddr());
				jsonObj.put("USERBIRTH", userInfo.getUserBirth());
				jsonObj.put("USERHP", userInfo.getUserHp());
				jsonObj.put("USERNAME", userInfo.getUserName());
				
				jsonArr.add(jsonObj);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
        
		return jsonArr;

	}

}

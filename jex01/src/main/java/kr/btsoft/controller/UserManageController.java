package kr.btsoft.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.btsoft.service.UserService;
import kr.btsoft.vo.UserVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserManageController {

	private static final Logger logger = LoggerFactory.getLogger(UserManageController.class);

	@Autowired
	private UserService userService;

	@PostMapping(value = "/selectAllUser")
	@ResponseBody
	public JSONArray selectAllUser(String userid) {

		List<UserVo> userList = userService.selectUsersInfo();
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

package web.local;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.LocalAuthExecution;
import entity.LocalAuth;
import entity.PersonInfo;
import enums.LocalAuthStateEnum;
import exceptions.LocalAuthOperationException;
import service.LocalAuthService;
import util.CodeUtil;
import util.HttpServletRequestUtil;

@Controller
@RequestMapping(value = "local", method = { RequestMethod.GET, RequestMethod.POST })
public class LocalAuthController {
	@Autowired
	private LocalAuthService localAuthService;

	@RequestMapping(value = "/bindlocalauth", method = RequestMethod.POST)
	@ResponseBody

	private Map<String, Object> bindLocalAuth(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String userName = HttpServletRequestUtil.getString(request, "userName");
		String password = HttpServletRequestUtil.getString(request, "password");
		PersonInfo user = (PersonInfo) request.getSession().getAttribute("user");
		if (userName != null && password != null && user != null && user.getUserId() != null) {
			LocalAuth localAuth = new LocalAuth();
			localAuth.setUsername(userName);
			localAuth.setPassword(password);
			localAuth.setPersonInfo(user);
			LocalAuthExecution le = localAuthService.bindLocalAuth(localAuth);
			if (le.getState() == LocalAuthStateEnum.SUCCESS.getState()) {
				modelMap.put("success", true);
			} else {
				modelMap.put("success", false);
				modelMap.put("errMsg", le.getStateInfo());
			}
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "username/password cannot be empty");
		}
		return modelMap;
	}

	@RequestMapping(value = "/changelocalpwd", method = RequestMethod.POST)
	@ResponseBody

	private Map<String, Object> changeLocalPwd(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		String userName = HttpServletRequestUtil.getString(request, "userName");
		String password = HttpServletRequestUtil.getString(request, "password");
		String newPassword = HttpServletRequestUtil.getString(request, "newPassword");
		PersonInfo user = (PersonInfo) request.getSession().getAttribute("user");
		if (userName != null && password != null && newPassword != null && user != null && user.getUserId() != null
				&& !password.equals(newPassword)) {
			try {
				LocalAuth localAuth = localAuthService.getLocalAuthByUserId(user.getUserId());
				if (localAuth == null || !localAuth.getUsername().equals(userName)) {
					modelMap.put("success", false);
					modelMap.put("errMsg", "invalid username");
					return modelMap;
				}
				LocalAuthExecution le = localAuthService.modifyLocalAuth(user.getUserId(), userName, password,
						newPassword);
				if (le.getState() == LocalAuthStateEnum.SUCCESS.getState()) {
					modelMap.put("success", true);
				} else {
					modelMap.put("success", false);
					modelMap.put("errMsg", le.getStateInfo());
				}
			} catch (LocalAuthOperationException e) {
				modelMap.put("success", false);
				modelMap.put("errMsg", e.toString());
				return modelMap;
			}

		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "please enter password");
		}
		return modelMap;
	}

	@RequestMapping(value = "/logincheck", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, Object> logincheck(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();

		String userName = HttpServletRequestUtil.getString(request, "userName");
		String password = HttpServletRequestUtil.getString(request, "password");
		if (userName != null && password != null) {
			LocalAuth localAuth = localAuthService.getLocalAuthByUsernameAndPwd(userName, password);
			if (localAuth != null) {
				modelMap.put("success", true);
				request.getSession().setAttribute("user", localAuth.getPersonInfo());
			} else {
				modelMap.put("success", false);
				modelMap.put("errMsg", "usename/password error");
			}
		} else {
			modelMap.put("success", false);
			modelMap.put("errMsg", "username/password cannot be empty");
		}
		return modelMap;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	@ResponseBody

	private Map<String, Object> logout(HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		request.getSession().setAttribute("user", null);
		modelMap.put("success", true);
		return modelMap;
	}
}

package online.cangjie.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;
import online.cangjie.po.TUser;
import online.cangjie.po.TYuding;
import online.cangjie.service.UserService;
import online.cangjie.utils.CodeUtil;
import online.cangjie.utils.EmailUtil;

@Controller
@RequestMapping(value = "/user/")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "login")
	public String login(HttpSession session, Model model, TUser user) {
		TUser u = userService.login(user);
		if (u != null) {
			session.setAttribute("user", u);
		}
		return "qiantai/default";
	}

	@RequestMapping(value = "register")
	public String register(Model model, String code, HttpSession session) {
		String rex = (String) session.getAttribute("code");
		if(rex.equals(code)){
		TUser user = (TUser) session.getAttribute("userinfo");
		int i = userService.register(user);
		if (i != 0)
			return "success";
		}
		return "false";
	}

	@RequestMapping(value = "checkMail.do")
	public String register1(Model model, TUser user, HttpSession session) {
		EmailUtil mail = EmailUtil.getEmailUtil();
		String code = CodeUtil.getCode();
		session.setAttribute("code", code);
		String msg = "验证码为：" + code;
		mail.sendEmail("验证邮箱，请勿回复此信息", msg, user.getUserEmail());
		session.setAttribute("userinfo", user);
		return "qiantai/userinfo/checkmail";
	}

	@RequestMapping(value = "logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "qiantai/default";
	}

	@RequestMapping(value = "index")
	public String index() {
		return "/auser/index";
	}

	@ResponseBody
	@RequestMapping(value = "changePassword")
	public String changePassword(TUser user, HttpSession session, String old) {
		JSONObject json = new JSONObject();
		TUser u = (TUser) session.getAttribute("user");
		System.out.println(u);
		System.out.println(user + "+++++++");
		if (u.getUserPw().equals(old)) {
			user.setUserId(u.getUserId());
			if (userService.changePassword(user))
				json.put("msg", "isChange");
			else {
				json.put("msg", "noChange");
			}
		} else {
			json.put("msg", "noChange");
		}
		return json.toString();
	}

	@RequestMapping(value = "changeInfo")
	public String changeInfo(TUser user, HttpSession session) {
		TUser u = (TUser) session.getAttribute("user");
		user.setUserId(u.getUserId());
		userService.changeInfo(user);
		u = userService.login(u);
		session.setAttribute("user", u);
		return "auser/userinfo/userinfo";
	}

	@RequestMapping(value = "dingdan")
	public String dingdan(HttpSession session, Model model) {
		TUser u = (TUser) session.getAttribute("user");
		TYuding yuding = new TYuding();
		yuding.setUserId(u.getUserId());
		model.addAttribute("dingdanList", userService.queryAll(yuding));
		return "auser/yuding/userYudingMy";
	}

	@ResponseBody
	@RequestMapping(value = "deleteDingdan")
	public String deleteDingdan(Integer id) {
		JSONObject json = new JSONObject();
		System.out.println(id);
		if (userService.deleteYuding(id))
			json.put("msg", "isDelete");
		else
			json.put("msg", "noDelete");
		return json.toString();
	}
}

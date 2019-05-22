package online.cangjie.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;
import online.cangjie.po.TAdmin;
import online.cangjie.po.TCheci;
import online.cangjie.po.TGonggao;
import online.cangjie.po.TUser;
import online.cangjie.po.TYuding;
import online.cangjie.service.AdminService;
import online.cangjie.utils.CookieUtil;

@Controller
@RequestMapping(value = "/admin/")
public class AdminController {
	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "toadmin")
	public String toAdmin(Model model, HttpServletRequest request, HttpServletResponse response){
		Cookie[] cookie = request.getCookies();
		Map<String, String> map = CookieUtil.getCookieAsMap(cookie);
		if(Boolean.valueOf(map.get("remember"))){
			TAdmin admin = new TAdmin(null, map.get("username"), map.get("password"));
			return login(admin, request.getSession(), request, response, false);
		}
		return "login";
	}
	
	@RequestMapping(value = "login")
	public String login(TAdmin admin, HttpSession session, HttpServletRequest request, HttpServletResponse response, boolean remember) {
		TAdmin u = adminService.Login(admin);
		if (u != null) {
			if(remember){
				Cookie cookie = new Cookie("username", u.getUsername());
				cookie.setMaxAge(7 * 24 * 60 * 60);
				response.addCookie(cookie);
				cookie = new Cookie("password", u.getUserpw());
				cookie.setMaxAge(7 * 24 * 60 * 60);
				response.addCookie(cookie);
				cookie = new Cookie("remember", Boolean.toString(remember));
				cookie.setMaxAge(7 * 24 * 60 * 60);
				response.addCookie(cookie);
			}
			session.setAttribute("admin", u);
			return "admin/index";
		}
		return "/login";
	}

	@RequestMapping(value = "logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "/login";
	}

	@ResponseBody
	@RequestMapping(value = "changePassword", method = { RequestMethod.POST, RequestMethod.GET })
	public String change(TAdmin admin, HttpSession session) throws IOException {
		JSONObject json = new JSONObject();
		TAdmin a = (TAdmin) session.getAttribute("admin");
		System.out.println(a);
		System.out.println(admin);
		if (a.getUserpw().equals(admin.getUserpw())) {
			if (adminService.changePassword(admin))
				json.put("msg", "isChange");
			else {
				json.put("msg", "noChange");
			}
		} else {
			json.put("msg", "noChange");
		}
		return json.toString();
	}

	@RequestMapping(value = "admin")
	public String admin(Model model) {
		model.addAttribute("adminLits", adminService.initAdminForm());
		return "admin/admin/adminMana";
	}

	@ResponseBody
	@RequestMapping(value = "deleteAdmin")
	public String delete(Integer id) {
		JSONObject json = new JSONObject();
		System.out.println(id);
		if (adminService.deleteAdmin(id))
			json.put("msg", "isDelete");
		else
			json.put("msg", "noDelete");
		return json.toString();
	}

	@RequestMapping(value = "addAdmin.do")
	public String addAdmin(TAdmin admin, Model model) {
		if (adminService.insertAdmin(admin))
			return this.admin(model);
		return "admin/admin/adminAdd";
	}

	@RequestMapping(value = "initUser")
	public String initUser(Model model) {
		model.addAttribute("userList", adminService.initUser());
		return "admin/user/userMana";
	}

	@ResponseBody
	@RequestMapping(value = "deleteUser")
	public String deleteUser(Integer id) {
		JSONObject json = new JSONObject();
		System.out.println(id);
		if (adminService.deleteUser(id))
			json.put("msg", "isDelete");
		else
			json.put("msg", "noDelete");
		return json.toString();
	}

	@RequestMapping(value = "checi")
	public String initCheci(Model model) {
		model.addAttribute("checi", adminService.initCheci());
		return "admin/checi/checiMana";
	}

	@ResponseBody
	@RequestMapping(value = "deleteCheci")
	public String deleteCheci(Integer id) {
		JSONObject json = new JSONObject();
		System.out.println(id);
		if (adminService.deleteCheci(id))
			json.put("msg", "isDelete");
		else
			json.put("msg", "noDelete");
		return json.toString();
	}

	@RequestMapping(value = "addCheci")
	public String addCheci(Model model, TCheci checi) {
		if (adminService.insertCheci(checi))
			return this.initCheci(model);
		return "admin/checi/checiAdd";
	}

	@RequestMapping(value = "changeCheci")
	public String initOneCheci(TCheci checi, Model model) {
		model.addAttribute("info", adminService.getCheci(checi));
		return "admin/checi/checiEditPre";
	}

	@RequestMapping(value = "updateCheci")
	public String updateCheci(TCheci checi, Model model) {
		if (adminService.updateCheci(checi))
			return this.initCheci(model);
		return "admin/checi/checiEditPre";
	}

	@RequestMapping(value = "yuding")
	public String initYuding(Model model) {
		System.out.println(adminService.initYuding());
		model.addAttribute("yudingList", adminService.initYuding());
		return "admin/yuding/yudingMana";
	}

	@ResponseBody
	@RequestMapping(value = "deleteYuding")
	public String deleteYuding(Integer id) {
		JSONObject json = new JSONObject();
		System.out.println(id);
		if (adminService.deleteYuding(id))
			json.put("msg", "isDelete");
		else
			json.put("msg", "noDelete");
		return json.toString();
	}

	@RequestMapping(value = "reserve.do")
	public String reserve(Integer id, Model model) {
		return this.initYuding(model);
	}

	@RequestMapping(value = "userInfo")
	public String userInfo(Integer id, Model model) {
		model.addAttribute("info", adminService.getUserInfo(id));
		return "admin/yuding/userxinxi";
	}

	@RequestMapping(value = "checiInfo")
	public String checiInfo(TCheci checi, Model model) {
		System.out.println(adminService.getCheci(checi));
		model.addAttribute("info", adminService.getCheci(checi));
		return "admin/yuding/chepiaoxinxi";
	}

	@RequestMapping(value = "shouli")
	public String shouli(Model model, TYuding yuding) {
		adminService.shouli(yuding);
		return this.initYuding(model);
	}

	@RequestMapping(value = "initGonggao")
	public String initGonggao(Model model) {
		model.addAttribute("gonggaoList", adminService.initGonggao());
		return "admin/gonggao/gonggaoMana";
	}
	
	@ResponseBody
	@RequestMapping(value = "addGonggao")
	public String addGonggao(HttpSession session, String context, String title){
		TAdmin admin = (TAdmin) session.getAttribute("admin");
		TGonggao gonggao = new TGonggao();
		gonggao.setGonggaoFabuzhe(admin.getUsername());
		gonggao.setGonggaoContent(context);
		gonggao.setGonggaoTitle(title);
		adminService.insertGonggao(gonggao);
		JSONObject js = new JSONObject();
		js.put("tag", "success");
		return js.toString();
	}

	@ResponseBody
	@RequestMapping(value = "deleteGonggao")
	public String deleteGonggao(Integer id) {
		JSONObject json = new JSONObject();
		System.out.println(id);
		if (adminService.deleteGonggao(id))
			json.put("msg", "isDelete");
		else
			json.put("msg", "noDelete");
		return json.toString();
	}

	@RequestMapping(value = "liuyan")
	public String initLiuyan(Model model) {
		model.addAttribute("liuyanList", adminService.initLiuyan());
		return "admin/liuyan/liuyanMana";
	}

	@ResponseBody
	@RequestMapping(value = "deleteLiuyan")
	public String deleteLiuyan(Integer id) {
		JSONObject json = new JSONObject();
		System.out.println(id);
		if (adminService.deleteLiuyan(id))
			json.put("msg", "isDelete");
		else
			json.put("msg", "noDelete");
		return json.toString();
	}
}

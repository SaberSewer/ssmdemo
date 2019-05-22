package online.cangjie.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import online.cangjie.po.TUser;
import online.cangjie.po.TYuding;
import online.cangjie.service.YudingService;

@Controller
@RequestMapping(value = "/yuding/")
public class YudingController {
	@Autowired
	private YudingService yudingService;
	
	@RequestMapping(value = "ding")
	public String xiadan(Model model, Integer id){
		model.addAttribute("checiInfo", yudingService.getCheci(id));
		return "qiantai/yuding/yuding";
	}
	
	@RequestMapping(value = "add")
	public String add(Model model, TYuding yuding, HttpSession session){
		TUser user = (TUser) session.getAttribute("user");
		yudingService.addYuding(yuding, user);
		return "success";
	}
}

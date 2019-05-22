package online.cangjie.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import online.cangjie.po.TCheci;
import online.cangjie.service.InitService;

@Controller
public class IndexController {
	@Autowired
	private InitService initService;

	@RequestMapping(value = "index.do")
	public String init(Model model, HttpSession session) {
		System.out.println(initService.getCheci());
		model.addAttribute("checi", initService.getCheci());
		session.setAttribute("gonggao", initService.getGonggao());
		return "/qiantai/index";
	}

	@RequestMapping(value = "search.do")
	public String search(TCheci checi, Model model) {
		model.addAttribute("checi", initService.getCheci(checi));
		return "/qiantai/index";
	}

	
	@RequestMapping(value = "liuyan")
	public String initLiuyan(Model model){
		model.addAttribute("liuyanList", initService.getLiuya());
		return "qiantai/liuyan/liuyanAll";
	}
}

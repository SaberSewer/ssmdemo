package online.cangjie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import online.cangjie.service.GonggaoService;

@Controller
@RequestMapping(value = "/gonggao/")
public class GonggaoController {
	@Autowired
	private GonggaoService gonggaoService;
	
	@RequestMapping(value = "show.do")
	public String show(Integer gonggaoId, Model model){
		model.addAttribute("news", gonggaoService.showGonggao(gonggaoId));
		return "/qiantai/gonggao/gonggaoDetailQian";
	}
}

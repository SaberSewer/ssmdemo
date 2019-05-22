package online.cangjie.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import online.cangjie.utils.JSONUtil;

@Controller
@RequestMapping(value = "/test/")
public class TestController {
	
	@ResponseBody
	@RequestMapping(value = "text")
	public String test(Model model, HttpServletRequest request, @RequestBody String json) throws IOException{
		System.out.println(json);
		String context = JSONUtil.getJSON(json);
		context = context.substring(0, context.length() -1);
		System.out.println(context);
		return "success";
	}
}

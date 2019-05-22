package online.cangjie.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.sf.json.JSONObject;
import online.cangjie.po.TLiuyan;
import online.cangjie.po.TUser;
import online.cangjie.service.LiuyanService;
import online.cangjie.utils.JSONUtil;

@Controller
@RequestMapping(value = "liuyan/")
public class LiuyanController {
	@Autowired
	private LiuyanService liuyanService;

	@ResponseBody
	@RequestMapping(value = "text")
	public String liuyan(HttpSession session, String context, String title) throws IOException {
		TUser user = (TUser) session.getAttribute("user");
		TLiuyan liuyan = new TLiuyan();
		if (user != null) {
			liuyan.setLiuyanUser(user.getUserName());
		}
		liuyan.setLiuyanContent(context);
		liuyan.setLiuyanTitle(title);
		liuyanService.save(liuyan);
		JSONObject js = new JSONObject();
		js.put("tag", "success");
		return js.toString();
	}

	@ResponseBody
	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public String upload(@RequestParam(value = "img") MultipartFile multipartFile, HttpSession session)
			throws IOException {
		JSONObject json = new JSONObject();
		String path = session.getServletContext().getRealPath("/upload/");
		String fileName = UUID.randomUUID().toString().replace("-", "");
		String suffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().indexOf("."),
				multipartFile.getOriginalFilename().length());
		FileOutputStream fos = new FileOutputStream(path + fileName + suffix);
		fos.write(multipartFile.getBytes());
		fos.close();
		json.put("data", "/upload/" + fileName + suffix);
		json.put("error", 0);
		return json.toString();
	}
}

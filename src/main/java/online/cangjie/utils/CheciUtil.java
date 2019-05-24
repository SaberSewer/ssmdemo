package online.cangjie.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import online.cangjie.dao.CheciDao;

public class CheciUtil {
	@Autowired
	private CheciDao checiDao;
	
	public void updateCheciInfo(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		Integer i = checiDao.updateCheciTimeAndTickNum(date);
		EmailUtil mail = EmailUtil.getEmailUtil();
		mail.sendEmail("自动更新表数据通知", "更新了" + i + "条数据", "317060952@qq.com");
	}
}

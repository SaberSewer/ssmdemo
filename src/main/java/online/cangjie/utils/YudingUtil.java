package online.cangjie.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import online.cangjie.dao.YudingDao;

public class YudingUtil {
	@Autowired
	private YudingDao yudingDao;

	public void autoSell() {
		EmailUtil mail = EmailUtil.getEmailUtil();
		List<String> list = yudingDao.queryState();
		if (!list.isEmpty()) {
			int i = yudingDao.autoUpdateState();
			mail.sendEmail("自动受理订单通知", "自动受理了" + i + "个订单", "317060952@qq.com");
			int x = 0;
			for (String str : list) {
				mail.sendEmail("受理通知", "您的订单已受理，详情请查看我的订单", str);
				x ++;
				if(x > 5)break;
			}
		}
	}
}

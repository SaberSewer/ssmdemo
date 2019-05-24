package online.cangjie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.cangjie.dao.CheciDao;
import online.cangjie.dao.YudingDao;
import online.cangjie.po.TCheci;
import online.cangjie.po.TUser;
import online.cangjie.po.TYuding;
import online.cangjie.service.YudingService;
import online.cangjie.utils.EmailUtil;

@Service
public class YudingServiceImpl implements YudingService {
	@Autowired
	private YudingDao yudingDao;
	@Autowired
	private CheciDao checiDao;
	
	@Override
	public boolean xiadan(TYuding yuding) {
		// TODO Auto-generated method stub
		return yudingDao.insertYuding(yuding) != 0;
	}

	@Override
	public TCheci getCheci(Integer id) {
		// TODO Auto-generated method stub
		TCheci checi = new TCheci();
		checi.setId(id);
		return 	checiDao.queryAll(checi).get(0);
	}

	@Override
	public Integer addYuding(TYuding yuding, TUser user) {
		// TODO Auto-generated method stub
		String mail = user.getUserEmail();
		EmailUtil emailUtil = EmailUtil.getEmailUtil();
		emailUtil.sendEmail("订单信息，请勿回复", "您的订单已提交，等待受理", mail);
		TCheci checi = new TCheci();
		checi.setId(yuding.getCheciId());
		checi.setPiaoshu(yuding.getYudingShumu());
		checiDao.updateTick(checi);
		return yudingDao.insertYuding(yuding);
	}

}

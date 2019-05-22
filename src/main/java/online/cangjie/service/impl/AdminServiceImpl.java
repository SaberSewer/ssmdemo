package online.cangjie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.cangjie.dao.AdminDao;
import online.cangjie.dao.CheciDao;
import online.cangjie.dao.GonggaoDao;
import online.cangjie.dao.LiuyanDao;
import online.cangjie.dao.UserDao;
import online.cangjie.dao.YudingDao;
import online.cangjie.po.TAdmin;
import online.cangjie.po.TCheci;
import online.cangjie.po.TGonggao;
import online.cangjie.po.TLiuyan;
import online.cangjie.po.TUser;
import online.cangjie.po.TYuding;
import online.cangjie.service.AdminService;
import online.cangjie.utils.EmailUtil;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private CheciDao checiDao;
	@Autowired
	private YudingDao yudingDao;
	@Autowired
	private GonggaoDao gonggaoDao;
	@Autowired
	private LiuyanDao liuyanDao;

	@Override
	public TAdmin Login(TAdmin admin) {
		// TODO Auto-generated method stub
		return adminDao.queryAdminByUsernameAndPassword(admin);
	}

	@Override
	public boolean changePassword(TAdmin admin) {
		// TODO Auto-generated method stub
		int i = adminDao.updateAdminPassword(admin);
		if (i != 0)
			return true;
		return false;

	}

	@Override
	public List<TAdmin> initAdminForm() {
		// TODO Auto-generated method stub
		return adminDao.queryAll();
	}

	@Override
	public boolean deleteAdmin(Integer id) {
		// TODO Auto-generated method stub
		int i = adminDao.deleteAdminById(id);
		if (i != 0)
			return true;
		return false;
	}

	@Override
	public boolean insertAdmin(TAdmin admin) {
		// TODO Auto-generated method stub
		int i = adminDao.insertAdmin(admin);
		if (i != 0)
			return true;
		return false;
	}

	@Override
	public List<TUser> initUser() {
		// TODO Auto-generated method stub
		return userDao.queryAll();
	}

	@Override
	public boolean deleteUser(Integer id) {
		// TODO Auto-generated method stub
		return userDao.deleteUserById(id) != 0;
	}

	@Override
	public List<TCheci> initCheci() {
		// TODO Auto-generated method stub
		return checiDao.queryAll();
	}

	@Override
	public boolean deleteCheci(Integer id) {
		// TODO Auto-generated method stub
		return checiDao.deleteCheciById(id) != 0;
	}

	@Override
	public boolean insertCheci(TCheci checi) {
		// TODO Auto-generated method stub
		return checiDao.insertCheci(checi) != 0;
	}

	@Override
	public TCheci getCheci(TCheci checi) {
		// TODO Auto-generated method stub
		
		return checiDao.queryAll(checi).get(0);
	}

	@Override
	public boolean updateCheci(TCheci checi) {
		// TODO Auto-generated method stub
		return checiDao.updateCheci(checi) != 0;
	}

	@Override
	public List<TYuding> initYuding() {
		// TODO Auto-generated method stub
		return yudingDao.queryAll();
	}

	@Override
	public boolean deleteYuding(Integer id) {
		// TODO Auto-generated method stub
		return yudingDao.deleteYudingById(id) != 0;
	}

	@Override
	public TUser getUserInfo(Integer id) {
		// TODO Auto-generated method stub
		return userDao.queryUserById(id);
	}

	@Override
	public List<TGonggao> initGonggao() {
		// TODO Auto-generated method stub
		return gonggaoDao.queryAll();
	}

	@Override
	public boolean deleteGonggao(Integer id) {
		// TODO Auto-generated method stub
		return gonggaoDao.deleteGonggaoById(id) != 0;
	}

	@Override
	public List<TLiuyan> initLiuyan() {
		// TODO Auto-generated method stub
		return liuyanDao.queryAll();
	}

	@Override
	public boolean deleteLiuyan(Integer id) {
		// TODO Auto-generated method stub
		return liuyanDao.deleteLiuyanById(id) != 0;
	}

	@Override
	public void shouli(TYuding yuding) {
		// TODO Auto-generated method stub
		yudingDao.updateState(yuding.getYudingId());
		TUser user =  userDao.queryUserById(yuding.getUserId());
		System.out.println(user.getUserEmail());
		EmailUtil email = EmailUtil.getEmailUtil();
		email.sendEmail("受理通知", "您的订单已受理，详情请查看我的订单", user.getUserEmail());
	}

	@Override
	public boolean insertGonggao(TGonggao gonggao) {
		// TODO Auto-generated method stub
		return gonggaoDao.save(gonggao) != 0;
	}

}

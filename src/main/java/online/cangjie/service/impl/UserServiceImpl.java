package online.cangjie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import online.cangjie.dao.UserDao;
import online.cangjie.dao.YudingDao;
import online.cangjie.po.TUser;
import online.cangjie.po.TYuding;
import online.cangjie.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	@Autowired
	private YudingDao yudingDao;

	@Override
	public int register(TUser user) {
		// TODO Auto-generated method stub
		return userDao.save(user);
	}

	@Override
	public TUser login(TUser user) {
		// TODO Auto-generated method stub
		return userDao.queryUserByIdAndPassword(user);
	}

	@Override
	public boolean changePassword(TUser user) {
		// TODO Auto-generated method stub
		return userDao.updatePassword(user) != 0;
	}

	@Override
	public boolean changeInfo(TUser user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user) != 0;
	}

	@Override
	public List<TYuding> queryAll(TYuding yuding) {
		// TODO Auto-generated method stub
		return yudingDao.queryAll(yuding);
	}

	@Override
	public boolean deleteYuding(Integer id) {
		// TODO Auto-generated method stub
		return yudingDao.deleteYudingById(id) != 0;
	}
	
	
}

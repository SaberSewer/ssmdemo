package online.cangjie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.cangjie.dao.LiuyanDao;
import online.cangjie.po.TLiuyan;
import online.cangjie.service.LiuyanService;

@Service
public class LiuyanServiceImpl implements LiuyanService {
	@Autowired
	private LiuyanDao liuyanDao;
	
	@Override
	public Integer save(TLiuyan liuyan) {
		// TODO Auto-generated method stub
		return liuyanDao.save(liuyan);
	}

}

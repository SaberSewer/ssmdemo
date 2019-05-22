package online.cangjie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.cangjie.dao.CheciDao;
import online.cangjie.dao.GonggaoDao;
import online.cangjie.dao.LiuyanDao;
import online.cangjie.po.TCheci;
import online.cangjie.po.TGonggao;
import online.cangjie.po.TLiuyan;
import online.cangjie.service.InitService;
@Service
public class InitServiceImpl implements InitService {
	@Autowired
	private CheciDao checiDao;
	@Autowired
	private GonggaoDao gonggaoDao;
	@Autowired
	private LiuyanDao liuyanDao;
	
	@Override
	public List<TGonggao> getGonggao() {
		// TODO Auto-generated method stub
		return gonggaoDao.queryTitle();
	}

	@Override
	public List<TCheci> getCheci() {
		// TODO Auto-generated method stub
		return checiDao.queryAll();
	}

	@Override
	public List<TCheci> getCheci(TCheci checi) {
		// TODO Auto-generated method stub
		return checiDao.queryAll(checi);
	}

	@Override
	public List<TLiuyan> getLiuya() {
		// TODO Auto-generated method stub
		return liuyanDao.queryAll();
	}

}

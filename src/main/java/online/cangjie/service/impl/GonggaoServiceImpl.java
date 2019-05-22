package online.cangjie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.cangjie.dao.GonggaoDao;
import online.cangjie.po.TGonggao;
import online.cangjie.service.GonggaoService;
@Service
public class GonggaoServiceImpl implements GonggaoService {
	@Autowired
	private GonggaoDao gonggaoDao;
	@Override
	public TGonggao showGonggao(Integer id) {
		// TODO Auto-generated method stub
		return gonggaoDao.queryGonggaoById(id);
	}

}

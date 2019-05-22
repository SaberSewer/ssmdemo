package online.cangjie.dao;

import java.util.List;

import online.cangjie.po.TGonggao;

public interface GonggaoDao {
	public List<TGonggao> queryTitle();
	
	public TGonggao queryGonggaoById(Integer id);
	
	public List<TGonggao> queryAll();
	
	public Integer deleteGonggaoById(Integer id);
	
	public Integer save(TGonggao gonggao);
}

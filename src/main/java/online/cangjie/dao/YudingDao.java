package online.cangjie.dao;

import java.util.List;

import online.cangjie.po.TYuding;

public interface YudingDao {
	public List<TYuding> queryAll();
	
	public List<TYuding> queryAll(TYuding yuding);
	
	public Integer deleteYudingById(Integer id);
	
	public Integer insertYuding(TYuding yuding);
	
	public void updateState(Integer id);
	
	public Integer autoUpdateState();
	
	public List<String> queryState();
}

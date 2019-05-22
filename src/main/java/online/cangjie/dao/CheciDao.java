package online.cangjie.dao;

import java.util.List;

import online.cangjie.po.TCheci;

public interface CheciDao {
	public List<TCheci> queryAll();
	
	public List<TCheci> queryAll(TCheci checi);
	
	public Integer deleteCheciById(Integer id);
	
	public Integer insertCheci(TCheci checi);
	
	public Integer updateCheci(TCheci checi);
	
	public Integer updateTick(TCheci checi);
}

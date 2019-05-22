package online.cangjie.dao;

import java.util.List;

import online.cangjie.po.TLiuyan;

public interface LiuyanDao {
	public List<TLiuyan> queryAll();
	
	public Integer deleteLiuyanById(Integer id);
	
	public Integer save(TLiuyan liuyan);
}

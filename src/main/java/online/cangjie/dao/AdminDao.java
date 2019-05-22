package online.cangjie.dao;

import java.util.List;

import online.cangjie.po.TAdmin;

public interface AdminDao {
	public TAdmin queryAdminByUsernameAndPassword(TAdmin admin);
	
	public Integer updateAdminPassword(TAdmin admin);
	
	public List<TAdmin> queryAll();
	
	public Integer deleteAdminById(Integer id);
	
	public Integer insertAdmin(TAdmin admin);
}

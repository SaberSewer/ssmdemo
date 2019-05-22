package online.cangjie.dao;

import java.util.List;

import online.cangjie.po.TUser;

public interface UserDao {
	public Integer save(TUser user);
	
	public TUser queryUserByIdAndPassword(TUser user);
	
	public List<TUser> queryAll();
	
	public Integer deleteUserById(Integer id);
	
	public TUser queryUserById(Integer id);
	
	public Integer updatePassword(TUser user);
	
	public Integer updateUser(TUser user);
}

package online.cangjie.service;

import java.util.List;

import online.cangjie.po.TUser;
import online.cangjie.po.TYuding;

public interface UserService {
	public int register(TUser user);

	public TUser login(TUser user);
	
	public boolean changePassword(TUser user);
	
	public boolean changeInfo(TUser user);
	
	public boolean deleteYuding(Integer id);
	
	public List<TYuding> queryAll(TYuding yuding);
	
}

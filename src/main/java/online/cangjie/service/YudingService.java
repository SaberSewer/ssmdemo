package online.cangjie.service;

import online.cangjie.po.TCheci;
import online.cangjie.po.TUser;
import online.cangjie.po.TYuding;

public interface YudingService {
	public boolean xiadan(TYuding yuding);
	
	public TCheci getCheci(Integer id);
	
	public Integer addYuding(TYuding yuding, TUser user );
}

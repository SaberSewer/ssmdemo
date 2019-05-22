package online.cangjie.service;

import java.util.List;

import online.cangjie.po.TAdmin;
import online.cangjie.po.TCheci;
import online.cangjie.po.TGonggao;
import online.cangjie.po.TLiuyan;
import online.cangjie.po.TUser;
import online.cangjie.po.TYuding;

public interface AdminService {
	public TAdmin Login(TAdmin admin);
	
	public TCheci getCheci(TCheci checi);

	public TUser getUserInfo(Integer id);
	
	public boolean changePassword(TAdmin admin);

	public List<TAdmin> initAdminForm();

	public List<TUser> initUser();

	public List<TCheci> initCheci();
	
	public List<TYuding> initYuding();
	
	public List<TGonggao> initGonggao();
	
	public List<TLiuyan> initLiuyan();

	public boolean deleteAdmin(Integer id);

	public boolean deleteUser(Integer id);

	public boolean deleteCheci(Integer id);
	
	public boolean deleteYuding(Integer id);

	public boolean deleteGonggao(Integer id);
	
	public boolean deleteLiuyan(Integer id);
	
	public boolean insertAdmin(TAdmin admin);
	
	public boolean insertCheci(TCheci checi);
	
	public boolean insertGonggao(TGonggao gonggao);
	
	public boolean  updateCheci(TCheci checi);
	
	public void shouli(TYuding yuding);

}

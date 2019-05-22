package online.cangjie.service;

import java.util.List;

import online.cangjie.po.TCheci;
import online.cangjie.po.TGonggao;
import online.cangjie.po.TLiuyan;

public interface InitService {
	public List<TGonggao> getGonggao();
	
	public List<TCheci> getCheci();
	
	public List<TCheci> getCheci(TCheci checi);
	
	public List<TLiuyan> getLiuya();
}

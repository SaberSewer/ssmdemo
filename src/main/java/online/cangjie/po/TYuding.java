package online.cangjie.po;

import java.io.Serializable;

public class TYuding implements Serializable{
	private Integer yudingId;

	private Integer userId;

	private Integer checiId;

	private Integer yudingShumu;

	private String yudingJine;

	private String zhifufangshi;

	private String yudingShijian;

	private String yudingZhuantai;

	public Integer getYudingId() {
		return yudingId;
	}

	public void setYudingId(Integer yudingId) {
		this.yudingId = yudingId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getCheciId() {
		return checiId;
	}

	public void setCheciId(Integer checiId) {
		this.checiId = checiId;
	}

	public Integer getYudingShumu() {
		return yudingShumu;
	}

	public void setYudingShumu(Integer yudingShumu) {
		this.yudingShumu = yudingShumu;
	}

	public String getYudingJine() {
		return yudingJine;
	}

	public void setYudingJine(String yudingJine) {
		this.yudingJine = yudingJine == null ? null : yudingJine.trim();
	}

	public String getZhifufangshi() {
		return zhifufangshi;
	}

	public void setZhifufangshi(String zhifufangshi) {
		this.zhifufangshi = zhifufangshi == null ? null : zhifufangshi.trim();
	}

	public String getYudingShijian() {
		return yudingShijian;
	}

	public void setYudingShijian(String yudingShijian) {
		this.yudingShijian = yudingShijian == null ? null : yudingShijian.trim();
	}

	public String getYudingZhuantai() {
		return yudingZhuantai;
	}

	public void setYudingZhuantai(String yudingZhuantai) {
		this.yudingZhuantai = yudingZhuantai == null ? null : yudingZhuantai.trim();
	}

	@Override
	public String toString() {
		return "TYuding [yudingId=" + yudingId + ", userId=" + userId + ", checiId=" + checiId + ", yudingShumu="
				+ yudingShumu + ", yudingJine=" + yudingJine + ", zhifufangshi=" + zhifufangshi + ", yudingShijian="
				+ yudingShijian + ", yudingZhuantai=" + yudingZhuantai + "]";
	}

}
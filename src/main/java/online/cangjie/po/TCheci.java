package online.cangjie.po;

import java.io.Serializable;

public class TCheci implements Serializable {
	private Integer id;

	private String shifazhan;

	private String daodazhan;

	private String piaoshijian;

	private String startshijian;

	private String endshijian;

	private Integer piaojia;

	private Integer piaoshu;

	private String del;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShifazhan() {
		return shifazhan;
	}

	public void setShifazhan(String shifazhan) {
		this.shifazhan = shifazhan == null ? null : shifazhan.trim();
	}

	public String getDaodazhan() {
		return daodazhan;
	}

	public void setDaodazhan(String daodazhan) {
		this.daodazhan = daodazhan == null ? null : daodazhan.trim();
	}

	public String getPiaoshijian() {
		return piaoshijian;
	}

	public void setPiaoshijian(String piaoshijian) {
		this.piaoshijian = piaoshijian == null ? null : piaoshijian.trim();
	}

	public String getStartshijian() {
		return startshijian;
	}

	public void setStartshijian(String startshijian) {
		this.startshijian = startshijian == null ? null : startshijian.trim();
	}

	public String getEndshijian() {
		return endshijian;
	}

	public void setEndshijian(String endshijian) {
		this.endshijian = endshijian == null ? null : endshijian.trim();
	}

	public Integer getPiaojia() {
		return piaojia;
	}

	public void setPiaojia(Integer piaojia) {
		this.piaojia = piaojia;
	}

	public Integer getPiaoshu() {
		return piaoshu;
	}

	public void setPiaoshu(Integer piaoshu) {
		this.piaoshu = piaoshu;
	}

	public String getDel() {
		return del;
	}

	public void setDel(String del) {
		this.del = del == null ? null : del.trim();
	}

	@Override
	public String toString() {
		return "TCheci [id=" + id + ", shifazhan=" + shifazhan + ", daodazhan=" + daodazhan + ", piaoshijian="
				+ piaoshijian + ", startshijian=" + startshijian + ", endshijian=" + endshijian + ", piaojia=" + piaojia
				+ ", piaoshu=" + piaoshu + ", del=" + del + "]";
	}

}
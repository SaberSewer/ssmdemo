package online.cangjie.po;

import java.io.Serializable;

public class TAdmin implements Serializable{
	private Integer userid;

	private String username;

	private String userpw;

	public TAdmin() {
		super();
	}

	public TAdmin(Integer userid, String username, String userpw) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpw = userpw;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw == null ? null : userpw.trim();
	}

	@Override
	public String toString() {
		return "TAdmin [userid=" + userid + ", username=" + username + ", userpw=" + userpw + "]";
	}

}
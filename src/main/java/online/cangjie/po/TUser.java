package online.cangjie.po;

import java.io.Serializable;
import java.util.Date;

public class TUser implements Serializable{
	private Integer userId;

	private String userName;

	private String userPw;

	private Integer userType;

	private String userRealname;

	private String userAddress;

	private String userSex;

	private String userTel;

	private String userEmail;

	private String userQq;

	private String userMan;

	private String userAge;

	private String userBirthday;

	private String userXueli;

	private String userOne1;

	private String userOne2;

	private String userOne3;

	private String userOne4;

	private String userOne5;

	private Integer userOne6;

	private Integer userOne7;

	private Integer userOne8;

	private Date userOne9;

	private Date userOne10;

	private String userOne11;

	private String userOne12;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw == null ? null : userPw.trim();
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getUserRealname() {
		return userRealname;
	}

	public void setUserRealname(String userRealname) {
		this.userRealname = userRealname == null ? null : userRealname.trim();
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress == null ? null : userAddress.trim();
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex == null ? null : userSex.trim();
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel == null ? null : userTel.trim();
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail == null ? null : userEmail.trim();
	}

	public String getUserQq() {
		return userQq;
	}

	public void setUserQq(String userQq) {
		this.userQq = userQq == null ? null : userQq.trim();
	}

	public String getUserMan() {
		return userMan;
	}

	public void setUserMan(String userMan) {
		this.userMan = userMan == null ? null : userMan.trim();
	}

	public String getUserAge() {
		return userAge;
	}

	public void setUserAge(String userAge) {
		this.userAge = userAge == null ? null : userAge.trim();
	}

	public String getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday == null ? null : userBirthday.trim();
	}

	public String getUserXueli() {
		return userXueli;
	}

	public void setUserXueli(String userXueli) {
		this.userXueli = userXueli == null ? null : userXueli.trim();
	}

	public String getUserOne1() {
		return userOne1;
	}

	public void setUserOne1(String userOne1) {
		this.userOne1 = userOne1 == null ? null : userOne1.trim();
	}

	public String getUserOne2() {
		return userOne2;
	}

	public void setUserOne2(String userOne2) {
		this.userOne2 = userOne2 == null ? null : userOne2.trim();
	}

	public String getUserOne3() {
		return userOne3;
	}

	public void setUserOne3(String userOne3) {
		this.userOne3 = userOne3 == null ? null : userOne3.trim();
	}

	public String getUserOne4() {
		return userOne4;
	}

	public void setUserOne4(String userOne4) {
		this.userOne4 = userOne4 == null ? null : userOne4.trim();
	}

	public String getUserOne5() {
		return userOne5;
	}

	public void setUserOne5(String userOne5) {
		this.userOne5 = userOne5 == null ? null : userOne5.trim();
	}

	public Integer getUserOne6() {
		return userOne6;
	}

	public void setUserOne6(Integer userOne6) {
		this.userOne6 = userOne6;
	}

	public Integer getUserOne7() {
		return userOne7;
	}

	public void setUserOne7(Integer userOne7) {
		this.userOne7 = userOne7;
	}

	public Integer getUserOne8() {
		return userOne8;
	}

	public void setUserOne8(Integer userOne8) {
		this.userOne8 = userOne8;
	}

	public Date getUserOne9() {
		return userOne9;
	}

	public void setUserOne9(Date userOne9) {
		this.userOne9 = userOne9;
	}

	public Date getUserOne10() {
		return userOne10;
	}

	public void setUserOne10(Date userOne10) {
		this.userOne10 = userOne10;
	}

	public String getUserOne11() {
		return userOne11;
	}

	public void setUserOne11(String userOne11) {
		this.userOne11 = userOne11 == null ? null : userOne11.trim();
	}

	public String getUserOne12() {
		return userOne12;
	}

	public void setUserOne12(String userOne12) {
		this.userOne12 = userOne12 == null ? null : userOne12.trim();
	}

	@Override
	public String toString() {
		return "TUser [userId=" + userId + ", userName=" + userName + ", userPw=" + userPw + ", userType=" + userType
				+ ", userRealname=" + userRealname + ", userAddress=" + userAddress + ", userSex=" + userSex
				+ ", userTel=" + userTel + ", userEmail=" + userEmail + ", userQq=" + userQq + ", userMan=" + userMan
				+ ", userAge=" + userAge + ", userBirthday=" + userBirthday + ", userXueli=" + userXueli + ", userOne1="
				+ userOne1 + ", userOne2=" + userOne2 + ", userOne3=" + userOne3 + ", userOne4=" + userOne4
				+ ", userOne5=" + userOne5 + ", userOne6=" + userOne6 + ", userOne7=" + userOne7 + ", userOne8="
				+ userOne8 + ", userOne9=" + userOne9 + ", userOne10=" + userOne10 + ", userOne11=" + userOne11
				+ ", userOne12=" + userOne12 + "]";
	}

}
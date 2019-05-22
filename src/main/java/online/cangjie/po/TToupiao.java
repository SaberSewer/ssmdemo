package online.cangjie.po;

import java.io.Serializable;

public class TToupiao implements Serializable {
	private Integer toupiaoId;

	private String toupiaoName;

	private String toupiaoDate;

	public Integer getToupiaoId() {
		return toupiaoId;
	}

	public void setToupiaoId(Integer toupiaoId) {
		this.toupiaoId = toupiaoId;
	}

	public String getToupiaoName() {
		return toupiaoName;
	}

	public void setToupiaoName(String toupiaoName) {
		this.toupiaoName = toupiaoName == null ? null : toupiaoName.trim();
	}

	public String getToupiaoDate() {
		return toupiaoDate;
	}

	public void setToupiaoDate(String toupiaoDate) {
		this.toupiaoDate = toupiaoDate == null ? null : toupiaoDate.trim();
	}
}
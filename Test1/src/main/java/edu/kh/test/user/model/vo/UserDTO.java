package edu.kh.test.user.model.vo;

public class UserDTO {
//	USER_NO NUMBER PRIMARY KEY,
//	USER_ID VARCHAR2(50) UNIQUE NOT NULL,
//	USER_NAME VARCHAR2(50) NOT NULL,
//	USER_AGE NUMBER NOT NULL
	
	private String userNo;
	private String userId;
	private String userName;
	private String userAge;
	
	
	public UserDTO() {
		super();
	}
	public UserDTO(String userNo, String userId, String userName, String userAge) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userName = userName;
		this.userAge = userAge;
	}
	@Override
	public String toString() {
		return "UserDTO [userNo=" + userNo + ", userId=" + userId + ", userName=" + userName + ", userAge=" + userAge
				+ "]";
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAge() {
		return userAge;
	}
	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}
	
	
}

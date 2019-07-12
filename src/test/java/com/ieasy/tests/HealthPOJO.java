package com.ieasy.tests;

public class HealthPOJO {
	private String PinCode;
	private String MobileNo;
	private String EmailID;
	private String SelfAge;

	public void setPinCode(String pinCode) {
	
			PinCode = pinCode;
	}
	
	public String getPinCode() {
		return PinCode;
	}

	public void setMobileNumber(String mobileNo) {
		// TODO Auto-generated method stub
		MobileNo = mobileNo;
	}

	public String getMobileNumber() {
		
		return MobileNo;
	}
	public void setEmailId(String emailID) {
		// TODO Auto-generated method stub
		EmailID = emailID;
	}
	
	public String getEmailId() {
		
		return EmailID;
	}

	public void setSelfAge(String selfAge) {
		
		SelfAge = selfAge;
	}
	
	public String getSelfAge() {
		
		return SelfAge;
	}

}

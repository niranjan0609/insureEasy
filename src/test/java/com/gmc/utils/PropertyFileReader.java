package com.gmc.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
 

public class PropertyFileReader {
 
    private static PropertyFileReader instance;
    private static final Object lock = new Object();
    private static String propertyFilePath = System.getProperty("user.dir")+
            "\\src\\test\\java\\resources\\config.properties";
    private static String username;
    private static String password;
    private static String adminURL;
    private static String invalidusername;
    private static String usernameToSearch;
    private static String countryCode;
    private static String mobileNo;
    private static String changeEmailID;
    private static String usernameToReset;
 
    //Create a Singleton instance. We need only one instance.
    public static PropertyFileReader getInstance () {
        if (instance == null) {
            synchronized (lock) {
                instance = new PropertyFileReader();
                instance.loadData();
            }
        }
        return instance;
    }
 
    //Get all configuration data and assign to related fields.
    private void loadData() {
        //Declare a properties object
        Properties prop = new Properties();
 
        //Read configuration.properties file
        try {
            prop.load(new FileInputStream(propertyFilePath));
            //prop.load(this.getClass().getClassLoader().getResourceAsStream("configuration.properties"));
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }
 
        //Get properties from configuration.properties
        username = prop.getProperty("username");
        password = prop.getProperty("password");
        adminURL = prop.getProperty("adminURL");
        invalidusername = prop.getProperty("invalidusername");
        usernameToSearch = prop.getProperty("usernameToSearch");
        countryCode = prop.getProperty("countryCode");
        mobileNo = prop.getProperty("mobileNo");
        changeEmailID = prop.getProperty("EmailID");
        usernameToReset = prop.getProperty("UsernameToReset");
    }
 
    public String getUsername () {
        return username;
    }
    
    public String getInvalidUsername () {
        return invalidusername;
    }
    public String getPassword () {
        return password;
    }
    
    public String getUserNameToSearch () {
        return usernameToSearch;
    }
    
    public String getAdminURL () {
        return adminURL;
    }

	public String getCountryCode() {
		// TODO Auto-generated method stub
		return countryCode;
	}

	public String getMobileNo() {
		// TODO Auto-generated method stub
		return mobileNo;
	}

	/*public String getEmailID() {
		// TODO Auto-generated method stub
		return changeEmailID;
	}*/

	public String getUserNameToReset() {
		// TODO Auto-generated method stub
		return usernameToReset;
	}

	public String getEmailID() {
		// TODO Auto-generated method stub
		return changeEmailID;
	}
}
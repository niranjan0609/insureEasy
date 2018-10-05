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
 
    //Create a Singleton instance. We need only one instanc.
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
 
        //Get properties from configuration.propertie
        username = prop.getProperty("username");
        password = prop.getProperty("password");
        adminURL = prop.getProperty("adminURL");
        invalidusername = prop.getProperty("invalidusername");
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
    
    public String getAdminURL () {
        return adminURL;
    }
}
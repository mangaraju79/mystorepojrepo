package com.mystore.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	//public static Properties prop;
	
	//public static WebDriver driver;
	
	public Properties prop;
	public static WebDriver driver;

	
	// in actual video it is static method
	@BeforeTest
	public void loadConfig() throws IOException {
		
		prop = new Properties();
		System.out.println("Super Constructor Invoked");
		String filepath= System.getProperty("user.dir")+"\\Configuration\\config.properties";
		FileInputStream fis = new FileInputStream(filepath);
		prop.load(fis);
		System.out.println("driver: "+ driver);
	}
	// in actual video it is static method
	public WebDriver launchApp() {
		
		String browsername= prop.getProperty("browser");
		
        if(browsername.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			
		}else if(browsername.equalsIgnoreCase("firefox")){
			
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			
		}else if (browsername.equalsIgnoreCase("ie")){
			
			WebDriverManager.iedriver().setup();
			driver= new InternetExplorerDriver();
			
		}
		
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
			
		return driver;
		
		
	}
}

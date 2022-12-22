package com.mystore.actiondriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.mystore.base.BaseClass;

public class Action extends BaseClass {
	
	public static void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
		
	}
	
	public static void click(WebDriver ldriver, WebElement locatorname) {
		
		Actions act = new Actions(ldriver);
		act.moveToElement(locatorname).click().build().perform();
		
	}
	
	
	
	
	
	

}

package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage {
	
	
	@FindBy(xpath="//a[@class='login']")
	WebElement sigInBtn;
	

}

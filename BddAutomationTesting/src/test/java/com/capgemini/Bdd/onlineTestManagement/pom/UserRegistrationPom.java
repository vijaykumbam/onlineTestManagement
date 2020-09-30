package com.capgemini.Bdd.onlineTestManagement.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserRegistrationPom {

	WebDriver driver;
	private By userUniqueId = By.id("uId");
	private By userName = By.id("uname");
	private By userPass =By.id("upass");
	private By registerButton =By.id("d");
	
	private String demoUseId="11606974";
	private String demoUserName="vijay Venkat";
	private String demoUserPassword ="H1234567";
	
	public UserRegistrationPom(WebDriver driver) {
		this.driver = driver;
	}
	
	
	/***************************************************
	 * METHOD      : userDetails
	 * PARAMETERS  : ()
	 * AUTHOR      : Vijayvenkat Reddy Kumbam
	 * DATE        : 30/09/2020
	 * DESCRIPTION : This method had the zero parameters and the values are hard coded
	 * 				This Method is implemented by the POM(Page object Model) 
	 * 
	 ***********************************************/
	public void userDetails() {
		driver.findElement(userUniqueId).sendKeys(demoUseId);
		driver.findElement(userName).sendKeys(demoUserName);
		driver.findElement(userPass).sendKeys(demoUserPassword);
	}
	
	
	/***************************************************
	 * METHOD      : confirmBookingButton
	 * PARAMETERS  :()
	 * AUTHOR      : Vijayvenkat Reddy Kumbam
	 * DATE        : 30/09/2020
	 * DESCRIPTION : This method will take the zero parameters
	 * 
	 ***********************************************/
	public void confirmBookingButton() {
		driver.findElement(registerButton).click();
	}
}

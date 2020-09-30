package com.capgemini.Bdd.onlineTestManagement.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindUserByUserIdPom {
	WebDriver driver;
	private By userUniqueId = By.id("uId");
	private By getButton =By.id("fUser");
	
	private String userUnique ="11606974";
	public FindUserByUserIdPom(WebDriver driver) {
		this.driver = driver;
	}
	
	/***************************************************
	 * METHOD      : findUserByUserId
	 * PARAMETERS  : ()
	 * AUTHOR      : Vijayvenkat Reddy Kumbam
	 * DATE        : 30/09/2020
	 * DESCRIPTION : This method had the zero parameters and the values are hard coded
	 * 				This Method is implemented by the POM(Page object Model) 
	 * 
	 ***********************************************/
	public void findUserByUserId() {
		driver.findElement(userUniqueId).sendKeys(userUnique);
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
		driver.findElement(getButton).click();
	}
}
	

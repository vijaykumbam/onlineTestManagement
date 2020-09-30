package com.capgemini.Bdd.onlineTestManagement.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GetAllExamsPom {
	
	WebDriver driver;
	private By getAllExamButton = By.xpath("//b[contains(text(),'GetExams!')]");
	
	
	public GetAllExamsPom(WebDriver driver) {
		this.driver = driver;
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
		driver.findElement(getAllExamButton).click();
	}
	
}

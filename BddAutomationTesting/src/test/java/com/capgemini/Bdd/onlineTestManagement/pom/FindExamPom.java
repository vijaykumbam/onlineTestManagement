package com.capgemini.Bdd.onlineTestManagement.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindExamPom {

	WebDriver driver;
	private By examId = By.id("exampleInputEmail1");
	private By getButton = By.xpath("//b[contains(text(),'FindExam!')]");
	
	private String examID = "2001";
	public FindExamPom(WebDriver driver) {
		this.driver = driver;
	}
	
	/***************************************************
	 * METHOD      : findExamByExamID
	 * PARAMETERS  : ()
	 * AUTHOR      : Vijayvenkat Reddy Kumbam
	 * DATE        : 30/09/2020
	 * DESCRIPTION : This method had the zero parameters and the values are hard coded
	 * 				This Method is implemented by the POM(Page object Model) 
	 * 
	 ***********************************************/
	public void findExamByExamID() {
		driver.findElement(examId).sendKeys(examID);
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

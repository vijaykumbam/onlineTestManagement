package com.capgemini.Bdd.onlineTestManagement.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AssignExamToUserPom {

	WebDriver driver;
	private By assignButton = By.xpath("//button[contains(text(),'assignExam')]");
	private By userId =By.xpath("//input[@id='userId']");
	private By examId = By.xpath("//input[@id='examId']");
	private By submitButton =By.id("b");
	
	
	private String demoUserId="11606974";
	private String demoExamId = "2002";
	public AssignExamToUserPom(WebDriver driver) {
		this.driver = driver;
	}
	
	
	/***************************************************
	 * METHOD      : gotoAssignPageByClicking
	 * PARAMETERS  : ()
	 * AUTHOR      : Vijayvenkat Reddy Kumbam
	 * DATE        : 30/09/2020
	 * DESCRIPTION : This method had the zero parameters and the values are hard coded
	 * 				This Method is implemented by the POM(Page object Model) 
	 * 
	 ***********************************************/
	public void gotoAssignPageByClicking() {
		driver.findElement(assignButton).click();
	}
	
	/***************************************************
	 * METHOD      : details
	 * PARAMETERS  : ()
	 * AUTHOR      : Vijayvenkat Reddy Kumbam
	 * DATE        : 30/09/2020
	 * DESCRIPTION : This method had the zero parameters and the values are hard coded
	 * 				This Method is implemented by the POM(Page object Model) 
	 * 
	 ***********************************************/
	public void details() {
		driver.findElement(userId).sendKeys(demoUserId);
		driver.findElement(examId).sendKeys(demoExamId);
	}
	
	/***************************************************
	 * METHOD      : submitButton
	 * PARAMETERS  : ()
	 * AUTHOR      : Vijayvenkat Reddy Kumbam
	 * DATE        : 30/09/2020
	 * DESCRIPTION : This method had the zero parameters and the values are hard coded
	 * 				This Method is implemented by the POM(Page object Model) 
	 * 
	 ***********************************************/
	public void submitButton() {
		driver.findElement(submitButton).click();
	}
	
}

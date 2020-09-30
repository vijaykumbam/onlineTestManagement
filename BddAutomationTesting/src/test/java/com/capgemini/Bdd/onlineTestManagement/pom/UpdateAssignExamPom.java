package com.capgemini.Bdd.onlineTestManagement.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UpdateAssignExamPom {
	WebDriver driver;
	private By assignedId = By.id("AssignedId");
	private By findUserButton =By.xpath("//b[contains(text(),'GetDetails!')]");
	private By changeButton= By.xpath("//button[contains(text(),'Change!')]");
	private By examId = By.xpath("//div[@class='col-sm']//div[2]//input[1]");
	private By updateButton = By.xpath("//button[contains(text(),'Update')]");
	
	
	private String demoAssignedId = "123451";
	private String demoExamId ="2002";
	
	public UpdateAssignExamPom(WebDriver driver) {
		this.driver = driver;
	}
	
	/***************************************************
	 * METHOD      : enterAssignedId
	 * PARAMETERS  : ()
	 * AUTHOR      : Vijayvenkat Reddy Kumbam
	 * DATE        : 30/09/2020
	 * DESCRIPTION : This method had the zero parameters and the values are hard coded
	 * 				This Method is implemented by the POM(Page object Model) 
	 * 
	 ***********************************************/
	public void enterAssignedId() {
		driver.findElement(assignedId).sendKeys(demoAssignedId);
	}
	
	/***************************************************
	 * METHOD      : clickFindButton
	 * PARAMETERS  : ()
	 * AUTHOR      : Vijayvenkat Reddy Kumbam
	 * DATE        : 30/09/2020
	 * DESCRIPTION : This method had the zero parameters and the values are hard coded
	 * 				This Method is implemented by the POM(Page object Model) 
	 * 
	 ***********************************************/
	public void clickFindButton() {
		driver.findElement(findUserButton).click();
	}
	
	/***************************************************
	 * METHOD      : changeButton
	 * PARAMETERS  : ()
	 * AUTHOR      : Vijayvenkat Reddy Kumbam
	 * DATE        : 30/09/2020
	 * DESCRIPTION : This method had the zero parameters and the values are hard coded
	 * 				This Method is implemented by the POM(Page object Model) 
	 * 
	 ***********************************************/
	public void changeButton() {		
		driver.findElement(changeButton).click();
	}
	
	/***************************************************
	 * METHOD      : enterExamID
	 * PARAMETERS  : ()
	 * AUTHOR      : Vijayvenkat Reddy Kumbam
	 * DATE        : 30/09/2020
	 * DESCRIPTION : This method had the zero parameters and the values are hard coded
	 * 				This Method is implemented by the POM(Page object Model) 
	 * 
	 ***********************************************/
	 public void enterExamID() {
		 driver.findElement(examId).sendKeys(demoExamId);
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
		driver.findElement(updateButton).click();
	}
	
}

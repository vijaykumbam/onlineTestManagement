package com.capgemini.Bdd.onlineTestManagement.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DateConflictCheckPom {

	WebDriver driver;
	private By userId = By.xpath("//input[@id='uId']");
	private By yyyy = By.xpath("//option[contains(text(),'2020')]");
	private By mm = By.xpath("//select[@id='month']//option[contains(text(),'7')]");
	private By dd = By.xpath("//select[@id='date']//option[contains(text(),'15')]");
	private By submit =By.id("cdc");
	
	
	
	public DateConflictCheckPom(WebDriver driver) {
		this.driver = driver;
	}
	
	/***************************************************
	 * METHOD      : dateConflictDetails
	 * PARAMETERS  : ()
	 * AUTHOR      : Vijayvenkat Reddy Kumbam
	 * DATE        : 30/09/2020
	 * DESCRIPTION : This method had the zero parameters and the values are hard coded
	 * 				This Method is implemented by the POM(Page object Model) 
	 * 
	 ***********************************************/
	public void dateConflictDetails() {
		driver.findElement(userId).sendKeys("11606975");
		}
	/***************************************************
	 * METHOD      : YYYY
	 * PARAMETERS  : ()
	 * AUTHOR      : Vijayvenkat Reddy Kumbam
	 * DATE        : 30/09/2020
	 * DESCRIPTION : This method had the zero parameters and the values are hard coded
	 * 				This Method is implemented by the POM(Page object Model) 
	 * 
	 ***********************************************/
	
	
	public void YYYY() {
		driver.findElement(yyyy).click();
	}
	/***************************************************
	 * METHOD      : MM
	 * PARAMETERS  : ()
	 * AUTHOR      : Vijayvenkat Reddy Kumbam
	 * DATE        : 30/09/2020
	 * DESCRIPTION : This method had the zero parameters and the values are hard coded
	 * 				This Method is implemented by the POM(Page object Model) 
	 * 
	 ***********************************************/
	public void MM() {
		driver.findElement(mm).click();
	}
	/***************************************************
	 * METHOD      : DD
	 * PARAMETERS  : ()
	 * AUTHOR      : Vijayvenkat Reddy Kumbam
	 * DATE        : 30/09/2020
	 * DESCRIPTION : This method had the zero parameters and the values are hard coded
	 * 				This Method is implemented by the POM(Page object Model) 
	 * 
	 ***********************************************/
	public void DD() {
		driver.findElement(dd).click();
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
		driver.findElement(submit).click();
	}
	
}

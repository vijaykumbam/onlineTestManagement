package com.capgemini.Bdd.onlineTestManagement.stepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

import com.capgemini.Bdd.onlineTestManagement.pom.ViewUserHistoryPom;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class ViewUserHistory {
	
	WebDriver driver=null;
	ViewUserHistoryPom viewUserHistoryPom;
	String path = System.getProperty("user.dir");
	String expectedTitle ="OnlineTestManagement";
	String webSiteUrl = "http://localhost:4300/user/userExamHistory";
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.opera.driver", path + "/src/test/resources/Driver/operadriver.exe");
		driver = new OperaDriver();	
		
	}

	@Given("User is already in the view History page")
	public void user_is_already_in_the_view_history_page() {
		driver.navigate().to(webSiteUrl);
		driver.manage().window().maximize();
		String title =driver.getTitle();
		System.out.println(title);
		if(expectedTitle.contentEquals(title)==false) {
			System.out.println("Sry you landed in wrong Planet!");
			driver.close();
			driver.quit();
			}
	}

	@When("User entered the UserId in input field")
	public void user_entered_the_user_id_in_input_field() {
		viewUserHistoryPom = new ViewUserHistoryPom(driver);
		viewUserHistoryPom.viewUserHistoryMethod();
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@And("user clicked the ViewHistory button")
	public void user_clicked_the_view_history_button() {
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 viewUserHistoryPom.confirmBookingButton();
	}

	@Then("User will get the List of his assigned Exam Details")
	public void user_will_get_the_list_of_his_assigned_exam_details() {
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 if(driver.getPageSource().contentEquals("2001") ||driver.getPageSource().contentEquals("2002")) {
			 System.out.println("data is shown");
		 }
		 else {
			 System.out.println("No data found");
		 }
	}
	
	@After
	public void closeResources() {
		System.out.println("Data resources were closed");
	    driver.close();
		driver.quit();
		
	}
	
}

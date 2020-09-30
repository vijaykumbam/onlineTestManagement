package com.capgemini.Bdd.onlineTestManagement.stepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

import com.capgemini.Bdd.onlineTestManagement.pom.DateConflictCheckPom;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class DateConflictCheck {

	WebDriver driver=null;
	DateConflictCheckPom dateConflictCheckPom;
	String path = System.getProperty("user.dir");
	String expectedTitle ="OnlineTestManagement";
	String webSiteUrl = "http://localhost:4300/admin/checkDateConflict";
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.opera.driver", path + "/src/test/resources/Driver/operadriver.exe");
		driver = new OperaDriver();	
		
	}
	
	
	@Given("User is already in the date conflict website")
	public void user_is_already_in_the_date_conflict_website() {
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

	@When("user Entered the UserId and date")
	public void user_entered_the_user_id_and_date() {
		System.out.println("Sry you landed in wrong Planet 1!");
		dateConflictCheckPom = new DateConflictCheckPom(driver);
		dateConflictCheckPom.dateConflictDetails();
		System.out.println("Sry you landed in wrong Planet! 2");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		dateConflictCheckPom.YYYY();
		System.out.println("Sry you landed in wrong Planet! 3");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		dateConflictCheckPom.MM();
		System.out.println("Sry you landed in wrong Planet! 4");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		dateConflictCheckPom.DD();
		System.out.println("Sry you landed in wrong Planet! 5");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
	}

	@And("user clicked on the check and proceed button")
	public void user_clicked_on_the_check_and_proceed_button() {
		System.out.println("Sry you landed in wrong Planet! 6");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		dateConflictCheckPom.submitButton();
		System.out.println("Sry you landed in wrong Planet! 7");
	}

	@Then("User will get the msg from the backend")
	public void user_will_get_the_msg_from_the_backend() {
	    try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String url = driver.getCurrentUrl();
		System.out.println("hello :"+url);
		String excpectedUrl= "http://localhost:4300/admin";
		if(excpectedUrl.contentEquals(url)) {
			System.out.println("Assign is Success");
		}
		else
		{
			System.out.println("Not able to Assign");
		}
	}
	
	@After
	public void closeResources() {
		System.out.println("Data resources were closed");
	    driver.close();
		driver.quit();
		
	}

}

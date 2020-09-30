package com.capgemini.Bdd.onlineTestManagement.stepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

import com.capgemini.Bdd.onlineTestManagement.pom.AssignExamToUserPom;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class AssignExamToUser {

	WebDriver driver=null;
	AssignExamToUserPom assignExamToUserPom;
	String path = System.getProperty("user.dir");
	String expectedTitle ="OnlineTestManagement";
	String webSiteUrl = "http://localhost:4300/admin";
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.opera.driver", path + "/src/test/resources/Driver/operadriver.exe");
		driver = new OperaDriver();	
		
	}
	
	
	@Given("User should be a valid")
	public void user_should_be_a_valid() {
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

	@When("user Entered the UserId and ExamId")
	public void user_entered_the_user_id_and_exam_id() {
		assignExamToUserPom = new AssignExamToUserPom(driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		assignExamToUserPom.gotoAssignPageByClicking();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		assignExamToUserPom.details();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	}

	@And("user clicked the assign button")
	public void user_clicked_the_assign_button() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		assignExamToUserPom.submitButton();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Then("User will get assigned to particular exam")
	public void user_will_get_assigned_to_particular_exam() {
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

package com.capgemini.Bdd.onlineTestManagement.stepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

import com.capgemini.Bdd.onlineTestManagement.pom.FindExamPom;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class FindExamByExamId {

	WebDriver driver=null;
	FindExamPom findExamPom;
	String path = System.getProperty("user.dir");
	String expectedTitle ="OnlineTestManagement";
	String webSiteUrl = "http://localhost:4300/user/viewExams";
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.opera.driver", path + "/src/test/resources/Driver/operadriver.exe");
		driver = new OperaDriver();	
		
	}
	
	
	@Given("User is already in the Search page of Exam Module")
	public void user_is_already_in_the_search_page_of_exam_module() {
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

	@When("User entered ExamId")
	public void user_entered_exam_id() {
		findExamPom = new FindExamPom(driver);
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		findExamPom.findExamByExamID();
	}

	@And("User entered the FindExam button")
	public void user_entered_the_find_exam_button() {
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 findExamPom.confirmBookingButton();
	}

	@Then("User will get the Exam Details")
	public void user_will_get_the_exam_details() {
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 driver.getPageSource().contentEquals("dotnet");
		 
	}
	@After
	public void closeResources() {
		System.out.println("Data resources were closed");
	    driver.close();
		driver.quit();
		
	}
}

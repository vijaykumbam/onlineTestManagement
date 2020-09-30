package com.capgemini.Bdd.onlineTestManagement.stepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

import com.capgemini.Bdd.onlineTestManagement.pom.GetAllExamsPom;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GetAllExams {

	
	WebDriver driver=null;
	GetAllExamsPom getAllExamsPom;
	String path = System.getProperty("user.dir");
	String expectedTitle ="OnlineTestManagement";
	String webSiteUrl = "http://localhost:4300/user/viewExams";
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.opera.driver", path + "/src/test/resources/Driver/operadriver.exe");
		driver = new OperaDriver();	
		
	}
	@Given("User is already in the page for to get List of Exams")
	public void user_is_already_in_the_page_for_to_get_list_of_exams() {
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

	@When("User clicked the  getExams button")
	public void user_clicked_the_get_exams_button() {
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		getAllExamsPom = new GetAllExamsPom(driver);
		getAllExamsPom.confirmBookingButton();
	}

	
	@Then("User will get the List of the Exam Details")
	public void user_will_get_the_list_of_the_exam_details() {
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if( driver.getPageSource().contentEquals("dotnet") && driver.getPageSource().contentEquals("java")) {
			System.out.println("List is appears!");
		}
		else
		{
			System.out.println(" Something is Wrong");
		}
	}

	
	@After
	public void closeResources() {
		System.out.println("Data resources were closed");
	    driver.close();
		driver.quit();
		
	}
	
}

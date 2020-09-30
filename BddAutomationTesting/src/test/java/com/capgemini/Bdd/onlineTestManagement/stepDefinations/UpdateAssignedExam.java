package com.capgemini.Bdd.onlineTestManagement.stepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

import com.capgemini.Bdd.onlineTestManagement.pom.UpdateAssignExamPom;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class UpdateAssignedExam {
	
	WebDriver driver=null;
	UpdateAssignExamPom updateAssignExamPom;
	String path = System.getProperty("user.dir");
	String expectedTitle ="OnlineTestManagement";
	String webSiteUrl = "http://localhost:4300/admin/viewAssignedExamByAssignedId";
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.opera.driver", path + "/src/test/resources/Driver/operadriver.exe");
		driver = new OperaDriver();	
	}
	
	
	
	@Given("User is already in the find user by userId page")
	public void user_is_already_in_the_find_user_by_user_id_page() {
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

	@When("User entered the change button")
	public void user_entered_the_change_button() {
		updateAssignExamPom = new UpdateAssignExamPom(driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		updateAssignExamPom.enterAssignedId();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		updateAssignExamPom.clickFindButton();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		updateAssignExamPom.changeButton();
		}

	@And("user entered the examId and submit the update button")
	public void user_entered_the_exam_id_and_submit_the_update_button() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		updateAssignExamPom.enterExamID();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		updateAssignExamPom.confirmBookingButton();
	}

	@Then("User will return the new page")
	public void user_will_return_the_new_page() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("hello-Then");
		String url = driver.getCurrentUrl();
		System.out.println("hello :"+url);
		String excpectedUrl= "http://localhost:4300/admin";
		if(excpectedUrl.contentEquals(url)) {
			System.out.println("Update is Success");
		}
		else
		{
			System.out.println("Not able to success");
		}
	}


	@After
	public void closeResources() {
		System.out.println("Data resources were closed");
	    driver.close();
		driver.quit();
		
	}
}

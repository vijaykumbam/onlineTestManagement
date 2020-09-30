package com.capgemini.Bdd.onlineTestManagement.stepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

import com.capgemini.Bdd.onlineTestManagement.pom.FindUserByUserIdPom;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FindUserByUserId {

	WebDriver driver = null;
	FindUserByUserIdPom findUserByUserIdPom;
	String path = System.getProperty("user.dir");
	String expectedTitle = "OnlineTestManagement";
	String webSiteUrl = "http://localhost:4300/user/viewUser";

	@Before
	public void setUp() {
		System.setProperty("webdriver.opera.driver", path + "/src/test/resources/Driver/operadriver.exe");
		driver = new OperaDriver();

	}

	@Given("User is already in the Search page")
	public void user_is_already_in_the_search_page() {
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

	@When("User entered UserId")
	public void user_entered_user_id() {
		findUserByUserIdPom = new FindUserByUserIdPom(driver);
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		findUserByUserIdPom.findUserByUserId();
		System.out.println("Data is entered");
	}

	@And("User entered the GetUser button")
	public void user_entered_the_get_user_button() {
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		findUserByUserIdPom.confirmBookingButton();
	}

	@Then("User will get the UserDetails")
	public void user_will_get_the_user_details() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.getPageSource().contentEquals("vijay ");
		System.out.println("Successfully found the User");
	}
	
	@After
	public void closeResources() {
		System.out.println("Data resources were closed");
	    driver.close();
		driver.quit();
		
	}

}

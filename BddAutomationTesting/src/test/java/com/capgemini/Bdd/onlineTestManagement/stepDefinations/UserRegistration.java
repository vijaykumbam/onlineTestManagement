//package com.capgemini.Bdd.onlineTestManagement.stepDefinations;
//
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.opera.OperaDriver;
//
//import com.capgemini.Bdd.onlineTestManagement.pom.UserRegistrationPom;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.en.*;
//
//public class UserRegistration {
//
//	WebDriver driver=null;
//	UserRegistrationPom userRegistrationPom;
//	String path = System.getProperty("user.dir");
//	String expectedTitle ="OnlineTestManagement";
//	String webSiteUrl = "http://localhost:4300/user/addUser";
//	
//	@Before
//	public void setUp() {
//		System.setProperty("webdriver.opera.driver", path + "/src/test/resources/Driver/operadriver.exe");
//		driver = new OperaDriver();	
//		
//	}
//	
//	@Given("User is already in the Registration page")
//	public void user_is_already_in_the_registration_page() {
//		driver.navigate().to(webSiteUrl);
//		driver.manage().window().maximize();
//		String title =driver.getTitle();
//		System.out.println(title);
//		if(expectedTitle.contentEquals(title)==false) {
//			System.out.println("Sry you landed in wrong Planet!");
//			driver.close();
//			driver.quit();
//		}
//	}
//
//	@When("User entered all the required details")
//	public void user_entered_all_the_required_details() {
//		userRegistrationPom= new UserRegistrationPom(driver);
//		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		userRegistrationPom.userDetails();
//	}
//
//	@And("User entered the register button")
//	public void user_entered_the_register_button() {
//		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		userRegistrationPom.confirmBookingButton();
//	}
//
//	@Then("User the page will redirect to the HomePage.")
//	public void user_the_page_will_redirect_to_the_home_page() {
//		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//	    driver.getPageSource().contentEquals("3 Mantras! of NEXTGENPLATFORM ");
//	    System.out.println("Registration is Success!");
//	}
//	
//	@After
//	public void closeResources() {
//		System.out.println("Data resources were closed");
//	    driver.close();
//		driver.quit();
//		
//	}
//}

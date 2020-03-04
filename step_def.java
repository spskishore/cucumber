package STEP_DEF;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class step_def {

	WebDriver dr;
	static String a_title,e_title,a_profilename,exp_profilename,xp,testresult;
	
	
	@Given("^Browser is launched and login displayed$")
	public void browser_is_launched_and_login_displayed() throws Throwable {
	   System.out.println("Browser is launched and login displayed");
	   System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	   dr=new ChromeDriver();
	   dr.get("http://demowebshop.tricentis.com/");
	}

	@When("^User enters login credentials and clicks on login$")
	public void user_enters_login_credentials_and_clicks_on_login() throws Throwable {
		 System.out.println("User enters login credentials and clicks on login");
	
		 dr.findElement(By.xpath("//div[@class='header-links']/ul/li[2]/a")).click(); //login
		 dr.findElement(By.xpath("//input[@class='email']")).sendKeys("spskishore@gmail.com");
		 dr.findElement(By.xpath("//input[@class='password']")).sendKeys("qwerty");
		 dr.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
		 a_profilename=dr.findElement(By.xpath("//div[@class='header-links']/ul/li[1]/a")).getText();
	}

	@Then("^Successful login happens and profile name displayed correctly$")
	public void successful_login_happens_and_profile_name_displayed_correctly() throws Throwable {
		 System.out.println("Successful login happens and profile name displayed correctly");
		 
		 e_title="Demo Web Shop";
		 a_title=dr.getTitle();
		 
		 exp_profilename="spskishore@gmail.com";
		 
		if(a_title.equals(e_title) && a_profilename.equals(exp_profilename))
		{
			testresult="PASS";
		}
		else
		{
			testresult="FAIL";
		}
		System.out.println("testresult: " +testresult);
	}
}

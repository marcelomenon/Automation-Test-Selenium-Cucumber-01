package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_Steps {
	
	
	private static WebDriver driver;
	
	@Before
	public void beforeScenario(){
		
		driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.get("http://localhost:8181/WebProjectTest02/add-car.html");
	}
	
	@After
	public void afterScenario(){
		driver.close();
	}
	
	@Given("^the '(.*?)' and '(.*?)' fields completed$")
	public void the_brand_and_type_fields_completed(String brand, String type) throws Throwable {
		 
		driver.findElement(By.xpath(".//input[@name='brand']")).sendKeys(brand);
		
		driver.findElement(By.xpath(".//input[@name='type']")).sendKeys(type);
	}

	@When("^I select '(.*?)'$")
	public void i_select_year(String year) throws Throwable {
		new Select (driver.findElement(By.xpath(".//select[@name='year']"))).selectByVisibleText(year);
	}
	

	@When("^I select the '(.*?)'$")
	public void i_select_the_fuel(String fuel) throws Throwable {
		driver.findElement(By.xpath(".//input[@value='"+fuel+"']")).click();;
	}

	@When("^I select the '(.*?)' option$")
	public void i_select_the_market_option(String market) throws Throwable {
		driver.findElement(By.xpath(".//input[@value='"+market+"']")).click();
	}

	@When("^I click on Save$")
	public void i_click_on_Save() throws Throwable {
		
		driver.findElement(By.xpath(".//input[@type='submit']")).click();
	}

	@Then("^I validate if the message is displayed with '(.*?)'  '(.*?)'  '(.*?)'  '(.*?)' and '(.*?)'$")
	public void i_validate_if_the_message_is_displayed_with_brand_type_year_fuel_and_market(String brand, String type, String year, String fuel, String market) throws Throwable {
		
		String message01 = driver.findElement(By.xpath("html/body")).getText();
		String message02 = ("Car " + (brand) + " " + (type) + " " + (year) + " " + (fuel)+ " " + "to " + (market) + " " + "added successful");
          
		try{
			Assert.assertEquals(message02, message01);
  
			System.out.println("Test Case Passed");
		}catch(AssertionError e){
			System.out.println("Test Case Failed");
		}
	}
		
}
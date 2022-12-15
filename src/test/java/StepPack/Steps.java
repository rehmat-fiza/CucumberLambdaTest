package StepPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps {
	
	public WebDriver driver;
	
	@Before()
	public void setup() {

		 WebDriverManager.chromedriver().setup();
		   driver = new ChromeDriver();
	}
	
	@Given("click on Radio Button Demo hyperlink")
	public void click_on_radio_button_demo_hyperlink() throws InterruptedException {
		
		
		   driver.get("https://www.lambdatest.com/selenium-playground/");
		   WebElement radioButton = driver.findElement(By.xpath("//a[text() ='Radio Buttons Demo']"));
		   radioButton.click();
		   Thread.sleep(2000);
		   String expectedText = "Radio button Demo";
	    	String actualText = driver.findElement(By.xpath("//h1[contains(text(),'Radio button Demo')]")).getText();
	    	Assert.assertEquals(actualText, expectedText, "Test case fail");
	    
	}

	@When("I validate the  functionality of Radio Button Demo")
	public void i_validate_the_functionality_of_radio_button_demo() {
		WebElement clickOnFemale = driver.findElement(By.xpath("(//input[@value='Female'])[1]"));
		clickOnFemale.click();
		WebElement getCheckedValue = driver.findElement(By.id("buttoncheck"));
		getCheckedValue .click();
		String expectedText = "Radio button 'Female' is checked";
    	String actualText = driver.findElement(By.xpath("//p[contains(text(),'Female' )]")).getText();
    	Assert.assertEquals(actualText, expectedText, "Test case fail");
	   
	}

	@Then("I validate the functioanlity of Group Radio Button Demo")
	public void i_validate_the_functioanlity_of_group_radio_button_demo() {
		WebElement clickOnFemale = driver.findElement(By.xpath("(//input[@value='Female'])[2]"));
		clickOnFemale.click();
		WebElement selectAgeGroup = driver.findElement(By.xpath("(//input[@type='radio'])[8]"));
		selectAgeGroup.click();
		WebElement getValue = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
		getValue.click();
		String expectedText = "Female";
    	String actualText = driver.findElement(By.xpath("//span[contains(text(),'Female' )]")).getText();
    	Assert.assertEquals(actualText, expectedText, "Test case fail");

	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}

}

package com.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Registration {

	WebDriver driver;

	public Registration(WebDriver driver) {
		super();
		this.driver = driver;
	}

	private By linkIcon = By.xpath("//h2[contains(text(),'Draggable')]/parent::a//figure");
	private By name = By.cssSelector("input[name='name']");
	private By phone = By.cssSelector("input[name='phone']");
	private By email = By.cssSelector("input[name='email']");
	private By country = By.cssSelector("select[name='country']");
	private By city = By.cssSelector("input[name='city']");
	private By username = By.xpath("(//input[@name='username'])[2]");
	private By password = By.xpath("(//input[@name='password'])[2]");
	private By submit = By.xpath("(//input[@class='button'])[2]");
	private By totalBoxes = By.xpath("//div[@class='row']/div[@class='linkbox margin-bottom-20']//li");
	private By userExists = By.xpath("//p[@id='alert']");
	private By signIn = By.xpath("//a[contains(text(),'Signin')]");
	private By existUsername = By.xpath("//input[@name='username'][@pb-role='username']");
	private By existPwd = By.xpath("//div[@id='login']//input[@name='password']");
	private By existSubmit = By.xpath("//div[@id='login']//input[@class='button']");
	// private By headers = By.xpath("//div[@class='linkbox
	// margin-bottom-20']/h1");
	// private By widgetBoxes = By.xpath("//div[@class='linkbox
	// margin-bottom-20']/h1[text()='Widget']/parent::div//ul/li");

	public WebElement linkIcon() {
		return driver.findElement(linkIcon);
	}

	public WebElement name() {
		return driver.findElement(name);
	}

	public WebElement phone() {
		return driver.findElement(phone);
	}

	public WebElement email() {
		return driver.findElement(email);
	}

	public WebElement country() {
		return driver.findElement(country);
	}

	public WebElement city() {
		return driver.findElement(city);
	}

	public WebElement username() {
		return driver.findElement(username);
	}

	public WebElement password() {
		return driver.findElement(password);
	}

	public WebElement submit() {
		return driver.findElement(submit);
	}

	public List<WebElement> totalBoxes() {
		return driver.findElements(totalBoxes);
	}
	public By userExistsVariable()
	{
		return userExists;
		
	}
	public WebElement userExists()
	{
		return driver.findElement(userExists);
	}
	public WebElement signIn()
	{
		return driver.findElement(signIn);
	}
	// public List<WebElement> allHeaders()
	// {
	// return driver.findElements(headers);
	// }
	// public List<WebElement> widgetBoxes()
	// {
	// return driver.findElements(widgetBoxes);
	// }
}

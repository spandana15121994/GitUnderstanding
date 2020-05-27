package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Interaction {

	WebDriver driver;

	public Interaction(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[contains(text(),'Draggable')]")
	private WebElement draggable;

	@FindBy(xpath = "//div[@id='example-1-tab-1']//iframe[@class='demo-frame']")
	private WebElement frame1;

	@FindBy(xpath = "//div[@id='draggable']")
	private WebElement dragAroundMe;

	public WebElement draggable() {
		return draggable;
	}

	public WebElement frame1() {
		return frame1;
	}

	public WebElement dragAroundMe() {
		return dragAroundMe;
	}
}

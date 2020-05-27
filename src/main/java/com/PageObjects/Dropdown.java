package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.Return;

public class Dropdown {

	WebDriver driver;

	public Dropdown(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='example-1-tab-1']//iframe[@class='demo-frame']")
	private WebElement countryFrame;

	@FindBy(xpath = "//select")
	private WebElement dropdownBox;

	@FindBy(xpath = "//a[contains(text(),'Enter Country')]")
	private WebElement enterCountryTab;
	
	@FindBy(xpath="//div[@id='example-1-tab-2']//iframe[@class='demo-frame']")
	private WebElement enterCountryFrameset;

	@FindBy(xpath = "//input[@class='custom-combobox-input ui-widget ui-widget-content ui-state-default ui-corner-left ui-autocomplete-input']")
	private WebElement enterCountry;

	public WebElement countryFrame() {
		return countryFrame;
	}

	public WebElement dropdownBox() {
		return dropdownBox;
	}
	public WebElement enterCountryFrameset()
	{
		return enterCountryFrameset;
	}

	public WebElement enterCountryTab() {
		return enterCountryTab;
	}

	public WebElement enterCountry()
	{
		return enterCountry;
	}
}

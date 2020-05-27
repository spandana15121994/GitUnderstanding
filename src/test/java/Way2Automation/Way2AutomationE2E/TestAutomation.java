package Way2Automation.Way2AutomationE2E;

import resources.Base;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import com.PageObjects.Dropdown;
import com.PageObjects.Interaction;
import com.PageObjects.Registration;

public class TestAutomation extends Base {

	WebDriver driver;
	Registration reg;
	WebDriverWait wait;
	Dropdown drop;
	Actions action;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@Test
	public void a_testRegistration() throws Exception {
		driver = getDriver();
		reg = new Registration(driver);
		wait = new WebDriverWait(driver, 40);
		String parentPage = driver.getWindowHandle();
		wait.until(ExpectedConditions.elementToBeClickable(reg.linkIcon())).click();
		// reg.linkIcon().click();
		log.info(driver.switchTo().window(parentPage).getTitle());
		Set<String> pages = driver.getWindowHandles();
		Iterator<String> itr = pages.iterator();
		while (itr.hasNext()) {
			String childWindow = itr.next();
			if (!parentPage.equals(childWindow)) {
				driver.switchTo().window(childWindow);
				log.info("Entered into IF block");
				log.info(driver.switchTo().window(childWindow).getTitle());
				reg.name().sendKeys("c45efd3ny");
				log.info("Entered Name");
				reg.phone().sendKeys("8123456783");
				log.info("Phone Number entered");
				reg.email().sendKeys("abcpqrxyz34@gmail.com");
				log.info("Email entered");
				log.info(reg.country().getAttribute("value"));
				reg.city().sendKeys("Hyderabad");
				log.debug("City entered");
				wait.until(ExpectedConditions.elementToBeClickable(reg.username())).click();
				String uname = "qpqrpqr178512@gmail.com";
				reg.username().sendKeys(uname);
				log.debug("Username entered");
				String pwd = "43uiouds444r5";
				reg.password().sendKeys(pwd);
				log.info("Password entered");
				reg.submit().click();
				log.info("Clicked on Register Button");
				Thread.sleep(3000);
				wait.until(ExpectedConditions.presenceOfElementLocated(reg.userExistsVariable()));
				String existingUser = reg.userExists().getText();
				log.info(existingUser);
				if (existingUser.contains("already exists")) {
					reg.signIn().click();
					String LoginPage = driver.findElement(By.xpath("//h3[contains(text(),'Login')]")).getText();
					log.info(LoginPage + "displayed. Enter your username and password");
					driver.findElement(By.xpath("//div[@id='login']//input[@name='username']")).sendKeys(uname);
					driver.findElement(By.xpath("//div[@id='login']//input[@name='password']")).sendKeys(pwd);
					driver.findElement(By.xpath("//div[@id='login']//input[@class='button']")).click();
				}
				log.info("Assignment1 completed successfully!!!");
				log.info("Total number of Boxes in this page are : " + reg.totalBoxes().size());
				Thread.sleep(3000);
				// List<WebElement> allHeaders =
				// driver.findElements(By.xpath("//div[@class='linkbox
				// margin-bottom-20']/h1"));
				// log.info("Total headers present in the page are :" +
				// allHeaders.size());
				for (int i = 0; i < driver.findElements(By.xpath("//div[@class='linkbox margin-bottom-20']/h1"))
						.size(); i++) {
					if (driver.findElements(By.xpath("//div[@class='linkbox margin-bottom-20']/h1")).get(i).getText()
							.equals("Widget")) {
						log.info("Entered into IF block after matching Widget");
						List<WebElement> widgetheaders = driver.findElements(By.xpath(
								"//div[@class='linkbox margin-bottom-20']/h1[text()='Widget']/parent::div//ul/li//h2"));

						log.info("Total Number of Boxes in Widget are :" + widgetheaders.size());
						log.info("List of sub categories present in Widget are: ");
						for (int j = 0; j < widgetheaders.size(); j++) {
							// WebElement wigBoxHeaders =
							// reg.widgetBoxes().get(j);
							log.info(widgetheaders.get(j).getText());

							// log.info(WidgetHeader);
						}
						break;
					}
					log.info("=========================================");
				}
			} else {
				log.info("pages matches");
			}

		}
	}

	// Click on the box with name DROPDOWN
	@Test
	public void b_dropdownFunctionality() throws InterruptedException {
		log.info("Second Method starts");
		for (int i = 0; i < driver.findElements(By.xpath("//div[@class='linkbox margin-bottom-20']/h1")).size(); i++) {
			List<WebElement> headersList = driver.findElements(By.xpath("//div[@class='linkbox margin-bottom-20']/h1"));
			String header = headersList.get(i).getText();
			log.info(header);
			List<WebElement> subHeaders = driver.findElements(By.xpath(
					"//div[@class='linkbox margin-bottom-20']/h1[text()='" + header + "']/parent::div//ul/li//h2"));
			for (int j = 0; j < subHeaders.size(); j++) {
				log.info(subHeaders.get(j).getText());
				if (subHeaders.get(j).getText().equals("Dropdown")) {
					subHeaders.get(j).click();
					log.info(driver.getTitle());
					log.info("Page naviagted to :" + driver
							.findElement(By.xpath("//div[@class='container margin-top-20']/h1[@class='heading']"))
							.getText());
				}

			}
			log.info("==============================================");
		}
		drop = new Dropdown(driver);
		driver.switchTo().frame(drop.countryFrame());
		log.info("Entered into frameset");
		Select options = new Select(drop.dropdownBox());
		options.selectByVisibleText("India");
		driver.switchTo().defaultContent();
		log.info("Came out of frameset");
		drop.enterCountryTab().click();
		driver.switchTo().frame(drop.enterCountryFrameset());
		log.info("Entered into frameset");
		drop.enterCountry().clear();
		drop.enterCountry().click();
		drop.enterCountry().sendKeys("IND");
		Thread.sleep(2000);
		drop.enterCountry().sendKeys(Keys.ARROW_DOWN);
		drop.enterCountry().sendKeys(Keys.ARROW_DOWN);
		drop.enterCountry().sendKeys(Keys.ENTER);
		driver.switchTo().defaultContent();
		log.info("Came out of frameset");
	}

	@Test
	public void c_testInteraction() {
		Interaction inter = new Interaction(driver);
		inter.draggable().click();
		driver.switchTo().frame(inter.frame1());
		action = new Actions(driver);
		action.dragAndDropBy(inter.dragAroundMe(), 100, 100).build().perform();

	}

	// @AfterSuite
	// public void tearDown() {
	// driver.quit();
	// }

}
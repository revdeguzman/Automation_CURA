import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class HealthcareService {

	WebDriver driver;
	
	public void launchBrowser() {
		
		//Locate chromedriver.exe
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium\\Automation_CURA\\CURA\\Other Files\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Action: Chrome Browser Launched.");
		
	}
	
	public void maxWindow() {
		
		//Maximize the window
		driver.manage().window().maximize();
		System.out.println("Action: Window Maximized.");
		
	}
	
	public void navigateURL() throws InterruptedException {
		
		//Navigate to URL
		driver.get("https://katalon-demo-cura.herokuapp.com/");
		Thread.sleep(2000);
		System.out.println("Action: Navigated to" + " " + driver.getCurrentUrl());
		
	}
	
	public void makeAppointment() throws InterruptedException, IOException {
		
		//Click Make Appointment Button
		driver.findElement(By.xpath("//*[@id=\"btn-make-appointment\"]")).click();
		
	}
	
	public void loginDemoAccount() throws InterruptedException, IOException {

		WebElement input_username = driver.findElement(By.xpath("//*[@id='login']/div/div/div[2]/form/div[1]/div[1]/div/div/input"));
		WebElement input_password = driver.findElement(By.xpath("//*[@id='login']/div/div/div[2]/form/div[1]/div[2]/div/div/input"));
		
		//Set text from login page
		driver.findElement(By.name("username")).sendKeys(input_username.getAttribute("value"));
		driver.findElement(By.name("password")).sendKeys(input_password.getAttribute("value"));
		
		//Call screenShot()
		screenShot();
		
		driver.findElement(By.id("btn-login")).click();
		System.out.println("Action: User Loged in");

	}
	
	public void scheduleAppointment() throws InterruptedException, IOException {
		
		//Select Value in Dropdown
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"combo_facility\"]"))); 
		dropdown.selectByVisibleText("Seoul CURA Healthcare Center");
		
		//Checkbox
		driver.findElement(By.xpath("//*[@id=\"chk_hospotal_readmission\"]")).click();
		
		//Healthcare Program, Choose one.
		driver.findElement(By.xpath("//*[@id=\"radio_program_medicaid\"]"));
		
		//Date
		driver.findElement(By.xpath("//*[@id=\"txt_visit_date\"]")).sendKeys("10/10/2024");
		
		//Comment
		driver.findElement(By.xpath("//*[@id=\"txt_comment\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"txt_comment\"]")).sendKeys("Test Comment");
		
		//Call screenShot()
		screenShot();
	
		//Click Book Appointment
		driver.findElement(By.xpath("//*[@id=\"btn-book-appointment\"]")).click();
		
	}
	
	public void confimationPage() throws InterruptedException, IOException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Call screenShot()
		screenShot();
		
	}
	
	public void menu() throws InterruptedException, IOException {
		
		//Wait for Element for 5 Seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//CLick Menu
		driver.findElement(By.xpath("//*[@id=\"menu-toggle\"]")).click();
		
		//Call screenShot()
		screenShot();
		
	}
	
	public void menuHome() throws InterruptedException, IOException {
		
		//Home
		driver.findElement(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[2]/a")).click();
		
		//Call screenShot()
		screenShot();
		
	}
	
	public void menuHistory() throws InterruptedException, IOException {
		
		//History
		driver.findElement(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[3]/a")).click();
		
		//Call screenShot()
		screenShot();
		
	}
	
	public void menuProfile() throws InterruptedException, IOException {
		
		//Profile
		driver.findElement(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[4]/a")).click();
		
		//Call screenShot()
		screenShot();
		
	}
	
	public void menuLogout() throws InterruptedException, IOException {
		
		//Logout
		driver.findElement(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[5]/a")).click();
		System.out.println("Action: User Logged out.");
		
		//Call screenShot()
		screenShot();
		
	}
	
	public void closeBrowser() throws InterruptedException {
		
		System.out.println("Closing Browser after 3 sconds.");
		Thread.sleep(3000);
		driver.quit();
		
	}
	
	public void screenShot() throws InterruptedException, IOException {

		//Take Screenshot
	    LocalDateTime myDateObj = LocalDateTime.now();  
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh.mm.ss a");  
	    String formattedDate = myDateObj.format(myFormatObj);  

		Screenshot FullPage = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(2000)).takeScreenshot(driver);
		ImageIO.write(FullPage.getImage(), "PNG", new File("G:\\Selenium\\Automation_CURA\\CURA\\Other Files\\Screenshot\\" + formattedDate + ".png"));

	}

}

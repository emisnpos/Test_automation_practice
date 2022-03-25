package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;

public class BaseTests {

    private EventFiringWebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new EventReporter());
        goHome();
        homePage = new HomePage(driver);

//        driver.manage().window().maximize();
//        driver.manage().window().fullscreen();  //fullscreen like f12
//        driver.manage().window().setSize(new Dimension(375, 667));

//        List<WebElement> links = driver.findElements(By.tagName("a"));  // ki listázza az 'a'tag-ű elementeket
//        System.out.println(links.size());

//        WebElement inputsLink =  driver.findElement(By.linkText("Inputs"));
//        inputsLink.click();

//        WebElement inputsLink =  driver.findElement(By.linkText("Bence"));  // NoSuchElementException <--- ha nem létezik a link akkor ezt a hibát küldi vissza
//        inputsLink.click();

        /*
        ** a harmadik video végén lévő feladat megoldása

        WebElement inputsLink =  driver.findElement(By.linkText("Shifting Content"));
        inputsLink.click();
        WebElement secondLink = driver.findElement(By.linkText("Example 1: Menu Element"));
        secondLink.click();

        List<WebElement> buttons = driver.findElements(By.tagName("li"));
        System.out.println(buttons.size());

        */

//        System.out.println(driver.getTitle());
//        ----------------------------------------             chapter 4.1 ----------------------------------------------


    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus())
        {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

}

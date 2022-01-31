package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

import java.util.List;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

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

        homePage =    new HomePage(driver);
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {

    private WebDriver driver;
    private By inputFiled = By.tagName("input");
    private By range = By.id("range");

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void moveSliderRange(Keys keys){
        driver.findElement(inputFiled).sendKeys(keys);
    }

    public String getResult(){
        return driver.findElement(range).getText();
    }
}

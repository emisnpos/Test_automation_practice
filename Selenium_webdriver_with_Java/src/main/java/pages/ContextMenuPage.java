package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {

    private WebDriver driver;
    private By inputField = By.id("hot-spot");
    Actions actions;


    public ContextMenuPage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(this.driver);
    }

    public void clickInputField(){
        actions.contextClick(driver.findElement(inputField)).perform();
    }

    public void acceptPopUp(){
        driver.switchTo().alert().accept();
    }

    public String getPopUpText(){
        return driver.switchTo().alert().getText();
    }


}

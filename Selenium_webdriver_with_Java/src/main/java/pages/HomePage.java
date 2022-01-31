package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver driver;
    private By fromAuthenticationLink = By.linkText("Form Authentication");

    public HomePage (WebDriver driver){
        this.driver = driver;
    }
    
    public LoginPage clickFormAuthentication(){
        
        driver.findElement(fromAuthenticationLink).click();
        return new LoginPage(driver);
    }

}

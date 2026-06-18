package ru.home.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage{

    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(id = "username")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(css = "[data-test='login-button']")
    private WebElement submitUserButton;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void login(String username, String password){
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
        submitUserButton.click();
    }

    public boolean isOpened(){
        return submitUserButton.isDisplayed();
    }

    public void logout(){

    }
}

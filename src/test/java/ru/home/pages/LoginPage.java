package ru.home.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.home.pages.base.BasePage;


public class LoginPage extends BasePage {
    @FindBy(id = "username")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(css = "[data-test='login-button']")
    private WebElement submitUserButtonLocator;

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);

    }

    public DashBoardPage login(String username, String password){
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
        submitUserButtonLocator.click();
        return new DashBoardPage(driver);
    }

    public boolean isOpened(){
        wait.until(ExpectedConditions.visibilityOf(submitUserButtonLocator));
        return submitUserButtonLocator.isDisplayed();
    }
}

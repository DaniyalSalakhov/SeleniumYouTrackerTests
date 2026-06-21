package ru.home.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.home.pages.base.BasePage;

public class ProfilePage extends BasePage {
    private NavBar navBar;
    @FindBy(css = "[data-test='ring-dropdown ring-profile']")
    private WebElement profileName;
    @FindBy(xpath = "//*[@data-test='userProfileFullName']//input")
    private WebElement profileNameForm;


    public ProfilePage(WebDriver driver){
        super(driver);
        navBar = new NavBar(driver);
        PageFactory.initElements(driver, this);
    }

    public String getProfileName(){
        driver.get("localhost:8080/dashboard");
        System.out.println();
        return profileName.getText();
    }

    public void setProfileName(String newName){
        driver.get("http://localhost:8080/users/me");
        wait.until(ExpectedConditions.elementToBeClickable(profileNameForm));
        profileNameForm.clear();
        profileNameForm.sendKeys(newName);
        By saveButton = By.xpath("//button[contains(.,'Сохранить')]");
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        driver.findElement(saveButton).click();
    }
}

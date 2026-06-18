package ru.home.pages.base;

import org.openqa.selenium.WebDriver;
import ru.home.pages.NavBar;

public class AuthorizedBasePage extends BasePage{
    protected NavBar navBar;

    public AuthorizedBasePage(WebDriver driver){
        super(driver);
        navBar = new NavBar(driver);
    }
}

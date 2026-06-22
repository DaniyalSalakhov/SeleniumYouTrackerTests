package ru.home.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.home.pages.DashBoardPage;
import ru.home.pages.LoginPage;
import ru.home.pages.ProfilePage;
import ru.home.tests.base.BaseTest;
import ru.home.utils.ScreenshotUtils;

public class ProfileTest extends BaseTest {
    private DashBoardPage dashBoardPage;

    @BeforeEach
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        dashBoardPage = loginPage.login("admin", "qwerty007");
    }


    @ParameterizedTest
    @CsvSource({"newName"})
    public void changeProfileName(String profileNameToSet){
        ProfilePage profilePage = dashBoardPage.getProfilePage();
        profilePage.setProfileName(profileNameToSet);
        String newProfileName = profilePage.getProfileName();
        if(!profileNameToSet.equals(newProfileName)){
            ScreenshotUtils.takeScreenshots(driver, "changeProfileName");
        }
        //Имя обновляется, но необходимо ждать 5 секунды, пока обновится в бд
        Assertions.assertEquals(profileNameToSet,newProfileName);
    }

    @AfterEach
    public void shutdown(){
        ProfilePage profilePage = dashBoardPage.getProfilePage();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.navigate().refresh();
        profilePage.setProfileName("admin");
    }
}

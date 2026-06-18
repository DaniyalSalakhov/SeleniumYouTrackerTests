package ru.home.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.home.pages.ProfilePage;
import ru.home.tests.base.AuthorizedBaseTest;
import ru.home.utils.ScreenshotUtils;

public class ProfileTest extends AuthorizedBaseTest {

    @ParameterizedTest
    @CsvSource({"newName"})
    public void changeProfileName(String profileNameToSet){
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.setProfileName(profileNameToSet);
        String newProfileName = profilePage.getProfileName();
        if(!profileNameToSet.equals(newProfileName)){
            ScreenshotUtils.takeScreenshots(driver, "changeProfileName");
        }
        //Имя обновляется, но необходимо перезагрузить страницу для правильного отображения
        Assertions.assertEquals(profileNameToSet,newProfileName);
    }
}

package io.vvrozhkova.bugredusers_ui.tests.login;

import io.qameta.allure.Story;
import io.vvrozhkova.bugredusers_common.config.App;
import io.vvrozhkova.bugredusers_ui.tests.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Story("Login tests")
public class LoginTests extends BaseTest {

    @Test
    @DisplayName("Successful login to account")
    void loginTest() {
        loginPage.open();
        loginPage.signIn(App.config.userEmail(), App.config.userPassword());
        usersPage.getNavbar()
                .checkThatUserAuthorizedAs(App.config.userName());
    }

    @Test
    @DisplayName("Successful sign out from account")
    void signOutTest() {
        loginPage.open();

        loginPage.signIn(App.config.userEmail(), App.config.userPassword());

        usersPage.getNavbar().signOut();
        loginPage.getNavbar().checkThatUserSignOut();
    }
}

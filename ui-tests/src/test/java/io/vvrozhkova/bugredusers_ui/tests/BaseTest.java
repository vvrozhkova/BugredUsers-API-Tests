package io.vvrozhkova.bugredusers_ui.tests;

import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import io.qameta.allure.junit5.AllureJunit5;
import io.restassured.RestAssured;
import io.vvrozhkova.bugredusers_common.config.App;
import io.vvrozhkova.bugredusers_ui.config.Project;
import io.vvrozhkova.bugredusers_ui.helpers.AllureAttachments;
import io.vvrozhkova.bugredusers_ui.helpers.DriverSettings;
import io.vvrozhkova.bugredusers_ui.helpers.DriverUtils;
import io.vvrozhkova.bugredusers_ui.pages.login.LoginPage;
import io.vvrozhkova.bugredusers_ui.pages.users.UsersPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({AllureJunit5.class})
public class BaseTest {

    protected final Faker faker = new Faker();

    protected final LoginPage loginPage = new LoginPage();
    protected final UsersPage usersPage = new UsersPage();

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = App.config.apiUrl();
        DriverSettings.configure();
    }

    @AfterEach
    public void addAttachments() {
        String sessionId = DriverUtils.getSessionId();

        AllureAttachments.addScreenshotAs("Last screenshot");
        AllureAttachments.addPageSource();
//        AllureAttachments.attachNetwork(); // todo
        AllureAttachments.addBrowserConsoleLogs();

        Selenide.closeWebDriver();

        if (Project.isVideoOn()) {
            AllureAttachments.addVideo(sessionId);
        }
    }

}

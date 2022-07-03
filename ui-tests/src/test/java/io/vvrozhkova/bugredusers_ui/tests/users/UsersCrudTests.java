package io.vvrozhkova.bugredusers_ui.tests.users;

import io.vvrozhkova.bugredusers_common.api.users.UsersApi;
import io.vvrozhkova.bugredusers_ui.helpers.WithLogin;
import io.vvrozhkova.bugredusers_ui.tests.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static org.junit.jupiter.api.Assertions.assertAll;

public class UsersCrudTests extends BaseTest {

    private final UsersApi usersApi = new UsersApi();
    private final String userName = faker.name().username();
    private final String userEmail = faker.internet().emailAddress();
    private final String userPassword = faker.internet().password();

    @Test
    @WithLogin
    @DisplayName("Create user")
    void createUser() {
        usersPage.open();

        usersPage.createNewUser(userName, userEmail, userPassword);

        usersPage.checkThatUsersListContainsUser(userName);
        usersPage.getUserTable().getRows().shouldHave(size(1));
        assertAll(
                () -> usersPage.getUserTable().checkThatUserNameIs(userName),
                () -> usersPage.getUserTable().checkThatUserEmailIs(userEmail)
        );
    }

    @Test
    @WithLogin
    @DisplayName("Update user info")
    void updateUser() {
        String newName = faker.name().username();
        String newEmail = faker.internet().emailAddress();

        usersApi.createUserWithTasks(userName, userEmail);

        usersPage.open();
        usersPage.searchUser(userName);

        assertAll(
                () -> {
                    usersPage.edtUser(userName).editEmail(newEmail);
                    usersPage.getUserTable().checkThatUserEmailIs(newEmail);
                },
                () -> {
                    usersPage.edtUser(userName).editName(newName);
                    usersPage.getUserTable().checkThatUserNameIs(newName);
                }
        );
    }

}

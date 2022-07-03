package io.vvrozhkova.bugredusers_ui.pages.users;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import io.vvrozhkova.bugredusers_ui.pages.common.PageWithNavbar;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class UsersPage extends PageWithNavbar {
    private final UsersTable userTable = new UsersTable();

    @Step("Open Users page")
    public void open() {
        Selenide.open("/");
    }

    @Step("Create new user with name [{name}]")
    public void createNewUser(String name, String email, String password) {
        $(byText("Добавить пользователя")).click();
        $(byName("noibiz_name")).setValue(name);
        $(byName("noibiz_email")).setValue(email);
        $(byName("noibiz_password")).setValue(password);
        $(byValue("Добавить пользователя")).click();
    }

    @Step("Search user by name [{name}]")
    public SelenideElement searchUser(String name) {
        $(byName("q")).setValue(name).pressEnter();
        return userTable.findRowWithValue("name", name);
    }

    @Step("Verify users list contains user with name [{name}]")
    public void checkThatUsersListContainsUser(String name) {
        searchUser(name);
        userTable.getRows().find(text(name)).shouldBe(visible);
    }

    @Step("Verify users list don't contains user with name [{name}]")
    public void checkThatUsersListDoNotContainsUser(String name) {
        searchUser(name);
        userTable.getRows().find(text(name)).shouldNotBe(visible);
    }

    public UsersTable getUserTable() {
        return userTable;
    }

    @Step("Edit user [{name}]")
    public EditUserPage edtUser(String name){
        userTable.clickEditUser(name);
        return new EditUserPage();
    }
}

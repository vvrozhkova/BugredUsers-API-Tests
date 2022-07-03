package io.vvrozhkova.bugredusers_ui.pages.users;

import io.qameta.allure.Step;
import io.vvrozhkova.bugredusers_ui.pages.common.Table;

import java.util.HashMap;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class UsersTable extends Table {

    public UsersTable() {
        super($(".content>.table"), new HashMap<>());
        columns.put("email", 1);
        columns.put("name", 2);
    }

    @Step("Verify user name is [{name}]")
    public void checkThatUserNameIs(String name) {
        getFirstRowColumn("name").shouldBe(text(name));
    }

    @Step("Verify user email is [{email}]")
    public void checkThatUserEmailIs(String email) {
        getFirstRowColumn("email").shouldBe(text(email));
    }

    public void clickEditUser(String name){
        findRowWithValue("name", name).find(byText("Изменить")).click();
    }
}

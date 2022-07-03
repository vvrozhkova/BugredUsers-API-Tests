package io.vvrozhkova.bugredusers_ui.pages.users;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class EditUserPage {

    @Step("Edit user name to [{newName}]")
    public void editName(String newName){
        $(byName("noibiz_name")).setValue(newName);
        $(byName("act_update")).click();
    }

    @Step("Edit user email to [{newEmail}]")
    public void editEmail(String newEmail){
        $(byName("noibiz_email")).setValue(newEmail);
        $(byName("act_update")).click();
    }


}

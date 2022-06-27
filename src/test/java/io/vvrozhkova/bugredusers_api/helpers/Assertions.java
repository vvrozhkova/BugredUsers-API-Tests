package io.vvrozhkova.bugredusers_api.helpers;

import io.qameta.allure.Step;

import static org.assertj.core.api.Assertions.assertThat;

public class Assertions {

    @Step("check '{name}' is equal to '{expected}'")
    public static void checkValueIsEqualTo(String name, Object actual, Object expected){
        assertThat(actual).isEqualTo(expected);
    }


}

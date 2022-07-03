package io.vvrozhkova.bugredusers_api.tests.authorization;

import io.vvrozhkova.bugredusers_common.api.registration.RegisterUserRequestDto;
import io.vvrozhkova.bugredusers_common.api.registration.RegisterUserResponseDto;
import io.vvrozhkova.bugredusers_common.api.registration.RegistrationApi;
import io.vvrozhkova.bugredusers_api.tests.BaseTest;
import io.vvrozhkova.bugredusers_common.config.App;
import org.junit.jupiter.api.Test;

import static io.vvrozhkova.bugredusers_common.helpers.Assertions.checkValueIsEqualTo;

public class RegistrationTests extends BaseTest {

    RegistrationApi registrationApi = new RegistrationApi();
//    RegisterUserRequestDto regUser = RegisterUserRequestDto.builder()
//            .email(faker.internet().emailAddress())
//            .name(faker.name().username())
//            .password(faker.internet().password())
//            .build();
    RegisterUserRequestDto regUser = RegisterUserRequestDto.builder()
            .email(App.config.userEmail())
            .name(App.config.userName())
            .password(App.config.userPassword())
            .build();

    @Test
    void registerUserTest(){
        RegisterUserResponseDto regUserInfo = registrationApi.registerUser(regUser);

        checkValueIsEqualTo("email", regUserInfo.getEmail(), regUser.getEmail());
        checkValueIsEqualTo("name", regUserInfo.getName(), regUser.getName());
    }
}

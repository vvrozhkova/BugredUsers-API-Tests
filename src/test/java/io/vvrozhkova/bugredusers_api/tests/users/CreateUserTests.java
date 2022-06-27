package io.vvrozhkova.bugredusers_api.tests.users;

import io.vvrozhkova.bugredusers_api.api.users.CreateUserApi;
import io.vvrozhkova.bugredusers_api.api.users.CreateUserRequestDto;
import io.vvrozhkova.bugredusers_api.api.users.CreateUserResponseDto;
import io.vvrozhkova.bugredusers_api.tests.BaseTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateUserTests extends BaseTest {

    private final CreateUserRequestDto user = CreateUserRequestDto.builder()
            .name(faker.name().username())
            .email(faker.internet().emailAddress())
            .password(faker.internet().password())
            //.companies(new int[]{73})
            //.tasks(new int[]{121})
            .build();

    @Test
    void createUserTest(){
        CreateUserApi userApi = new CreateUserApi();
        CreateUserResponseDto userInfo = userApi.createUser(user);
        assertThat(userInfo).usingRecursiveComparison()
                .ignoringExpectedNullFields()
                .isEqualTo(user);
    }
}

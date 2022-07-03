package io.vvrozhkova.bugredusers_api.tests.users;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.vvrozhkova.bugredusers_api.tests.BaseTest;
import io.vvrozhkova.bugredusers_common.api.users.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateUserTests extends BaseTest {

    @Test
    void createUserTest() {
        CreateUserRequestDto user = prepareUserRq();
        CreateUserResponseDto userInfo = userApi.createUser(user);
        assertThat(userInfo).usingRecursiveComparison()
                .ignoringExpectedNullFields()
                .isEqualTo(user);

        userApi.deleteUser(user.getName(), user.getEmail());
    }

//    @Test
//    void createUserWithTasksTest() {
//        CreateUserWithTasksRequestDto user = userApi.prepareUserWithTasksRq();
//        CreateUserWithTasksResponseDto userInfo = userApi.createUserWithTasks(user);
//        assertThat(userInfo).usingRecursiveComparison()
//                .ignoringExpectedNullFields()
//                .isEqualTo(user);
//
//        userApi.deleteUser(user.getName(), user.getEmail());
//    }

    @Test
    void deleteUserTest() {
        CreateUserWithTasksResponseDto userWithTasks = createUserWithTasks();
        DeleteUserRequestDto userToDelete = DeleteUserRequestDto.builder()
                .name(userWithTasks.getName())
                .email(userWithTasks.getEmail())
                .build();

        ExtractableResponse<Response> deleteUserResponse = userApi.deleteUser(userToDelete);
        DeleteUserResponseDto userInfo = userApi.checkDeleteUserResponse(deleteUserResponse);
        assertThat(userInfo).usingRecursiveComparison()
                .ignoringExpectedNullFields()
                .isEqualTo(userToDelete);
    }

    @Test
    void getUserInfoTest(){
        UserInfoRequestDto user = UserInfoRequestDto.builder()
                .name("lavina.connelly")
                .email("kenneth.rowe@hotmail.com")
                .build();
        UserInfoResponseDto userFullInfo = userApi.getUserFullInfo(user);
        assertThat(userFullInfo).usingRecursiveComparison()
                .ignoringExpectedNullFields()
                .isEqualTo(user);
    }

}

package io.vvrozhkova.bugredusers_api.tests.authorization;

import io.vvrozhkova.bugredusers_common.api.authorization.AuthorizationApi;
import io.vvrozhkova.bugredusers_api.tests.BaseTest;
import org.junit.jupiter.api.Test;

public class LoginTests extends BaseTest {

    @Test
    void loginTest(){
        AuthorizationApi.doLoginAsDefaultUser()
                .then()
                    .statusCode(200);
    }

}

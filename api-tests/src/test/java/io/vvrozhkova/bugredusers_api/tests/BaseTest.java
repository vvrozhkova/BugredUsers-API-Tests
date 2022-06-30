package io.vvrozhkova.bugredusers_api.tests;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.vvrozhkova.bugredusers_api.config.App;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    protected final Faker faker = new Faker();

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = App.config.apiUrl();
    }





}

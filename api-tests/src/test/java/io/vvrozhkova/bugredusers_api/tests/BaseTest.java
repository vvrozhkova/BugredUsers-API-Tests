package io.vvrozhkova.bugredusers_api.tests;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.vvrozhkova.bugredusers_common.api.companies.CompaniesApi;
import io.vvrozhkova.bugredusers_common.api.companies.CompanyType;
import io.vvrozhkova.bugredusers_common.api.companies.CreateCompanyRequestDto;
import io.vvrozhkova.bugredusers_common.api.companies.CreateCompanyResponseDto;
import io.vvrozhkova.bugredusers_common.api.tasks.CreateTaskRequestDto;
import io.vvrozhkova.bugredusers_common.api.tasks.CreateTaskResponseDto;
import io.vvrozhkova.bugredusers_common.api.tasks.TasksApi;
import io.vvrozhkova.bugredusers_common.api.users.CreateUserRequestDto;
import io.vvrozhkova.bugredusers_common.api.users.CreateUserWithTasksResponseDto;
import io.vvrozhkova.bugredusers_common.api.users.UsersApi;
import io.vvrozhkova.bugredusers_common.config.App;
import org.junit.jupiter.api.BeforeAll;

import static java.lang.Integer.parseInt;

public class BaseTest {
    protected final Faker faker = new Faker();

    public CompaniesApi companiesApi = new CompaniesApi();
    public TasksApi tasksApi = new TasksApi();
    public UsersApi userApi = new UsersApi();

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = App.config.apiUrl();
    }

    public CreateUserRequestDto prepareUserRq() {
        CreateCompanyResponseDto company = createCompany();
        CreateTaskResponseDto task = createTaskAndAssignToUser();
        return CreateUserRequestDto.builder()
                .name(faker.name().username())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password())
                .companies(new int[]{parseInt(company.getId())})
                .tasks(new int[]{parseInt(task.getId())})
                .build();
    }

    public CreateUserWithTasksResponseDto createUserWithTasks() {
        return userApi.createUserWithTasks(faker.name().username(), faker.internet().emailAddress());
    }

    public CreateCompanyRequestDto prepareCompanyRq() {
        return CreateCompanyRequestDto.builder()
                .name(faker.company().name())
                .type(CompanyType.OAO.getType())
                .owner(App.config.userEmail())
                .emails(new String[]{App.config.userEmail()})
                .build();
    }

    public CreateCompanyResponseDto createCompany() {
        CreateCompanyRequestDto company = prepareCompanyRq();
        return companiesApi.createCompany(company);
    }

    public CreateTaskRequestDto prepareTaskRq() {
        return CreateTaskRequestDto.builder()
                .title(faker.funnyName().name())
                .description(faker.lorem().sentence(3))
                .owner(App.config.userEmail())
                .email(App.config.userEmail())
                .build();
    }

    public CreateTaskResponseDto createTaskAndAssignToUser() {
        CreateTaskRequestDto task = prepareTaskRq();
        return tasksApi.createTask(task);
    }
}

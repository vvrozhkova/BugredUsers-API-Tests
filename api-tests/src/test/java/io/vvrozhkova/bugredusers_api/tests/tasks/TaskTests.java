package io.vvrozhkova.bugredusers_api.tests.tasks;

import io.vvrozhkova.bugredusers_common.helpers.youtrack.TestCaseId;
import io.vvrozhkova.bugredusers_api.tests.BaseTest;
import io.vvrozhkova.bugredusers_common.api.tasks.*;
import io.vvrozhkova.bugredusers_common.config.App;
import org.junit.jupiter.api.Test;

import static io.vvrozhkova.bugredusers_common.helpers.Assertions.checkValueIsEqualTo;

public class TaskTests extends BaseTest {

    private final String ownerEmail = App.config.userEmail();
    private final String userEmail = App.config.userEmail();

    CreateTaskRequestDto task = CreateTaskRequestDto.builder()
            .title(faker.funnyName().name())
            .description(faker.lorem().sentence(3))
            .owner(ownerEmail)
            .email(userEmail)
            .build();

    @Test
    @TestCaseId("BU-9")
    void createTask() {
        CreateTaskResponseDto response = tasksApi.createTask(task);

        checkValueIsEqualTo("message", response.getMessage(),
                "Задача успешно создана!");

        deleteTask(response.getId(), ownerEmail);
    }

    @Test
    @TestCaseId("BU-10")
    void updateTask() {
        String taskId = tasksApi.createTask(task).getId();
        UpdateTaskRequestDto updateTask = UpdateTaskRequestDto.builder()
                .id(taskId)
                .owner(ownerEmail)
                .email(userEmail)
                .title(faker.funnyName().name())
                .description(faker.lorem().sentence(3))
                .build();

        UpdateTaskResponseDto response = tasksApi.updateTask(updateTask);

        checkValueIsEqualTo("message", response.getMessage(),
                "Задача успешно изменена!");

        deleteTask(taskId, ownerEmail);
    }

    @Test
    @TestCaseId("BU-11")
    void deleteTask() {
        String taskId = tasksApi.createTask(task).getId();

        DeleteTaskResponseDto response = deleteTask(taskId, ownerEmail);

        checkValueIsEqualTo("message", response.getMessage().trim(),
                String.format("Задача с ID %s успешно удалена", taskId));
    }

    DeleteTaskResponseDto deleteTask(String taskId, String ownerEmail) {
        DeleteTaskRequestDto deleteTask = DeleteTaskRequestDto.builder()
                .id(taskId)
                .owner(ownerEmail)
                .build();

        return tasksApi.deleteTask(deleteTask);
    }
}

package io.vvrozhkova.bugredusers_common.helpers.youtrack;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.vvrozhkova.bugredusers_common.config.App;
import io.vvrozhkova.bugredusers_common.helpers.AllureRestAssuredFilter;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class YoutrackExtension implements AfterEachCallback {
    @Override
    public void afterEach(ExtensionContext context) {
        String testCaseId = context.getRequiredTestMethod().getAnnotation(TestCaseId.class).value();
        TestStatus testResult = context.getExecutionException().isPresent() ? TestStatus.FAILED : TestStatus.PASSED;

        String issueTitle = getIssueTitle(testCaseId);
        String executionId = getIssueExecution(issueTitle);
        updateIssueStatus(executionId, testResult);
    }

    private void updateIssueStatus(String issueId, TestStatus status) {
        YoutrackUpdateStatusRequestDto newStatus = YoutrackUpdateStatusRequestDto.builder().event(
                YoutrackUpdateStatusRequestDto.StatusInfo.builder()
                        .presentation(status.getPresentation())
                        .id(status.getId())
                        .type("Event").build()
        ).build();

        String path = String.format("/issues/%s/fields/114-46?fields=id,name,value(id,name)", issueId);

        RestAssured.given().baseUri("https://vvrozhkova.myjetbrains.com/youtrack/api")
                .filter(AllureRestAssuredFilter.withCustomTemplates())
                .header("Authorization", "Bearer " + App.config.youtrackToken())
                .contentType(ContentType.JSON)
                .body(newStatus)
                .when()
                .post(path)
                .then()
                .statusCode(200);
    }

    private String getIssueExecution(String issueTitle) {
        String testRunId = App.config.testRun();
        String path = String.format("/issues/%s/links?fields=issues(id,idReadable,summary)", testRunId);

        YoutrackLinksResponseDto[] links = RestAssured.given().baseUri("https://vvrozhkova.myjetbrains.com/youtrack/api")
                .header("Authorization", "Bearer " + App.config.youtrackToken())
                .contentType(ContentType.JSON)
                .when()
                .get(path)
                .then()
                .statusCode(200)
                .extract().as(YoutrackLinksResponseDto[].class);


        Optional<YoutrackIssueInfoDto[]> linkedIssues = Arrays.stream(links)
                .map(YoutrackLinksResponseDto::getIssues)
                .filter(issues -> issues.length > 0).findFirst();

        List<YoutrackIssueInfoDto> issuesWithTitle;

        if (linkedIssues.isPresent()) {
            issuesWithTitle = Arrays.stream(linkedIssues.get())
                    .filter((i) -> i.getSummary().contains(issueTitle))
                    .collect(Collectors.toList());
        } else {
            throw new RuntimeException("Unable to find linked issues for test run with id='" + testRunId + "'.");
        }

        if (issuesWithTitle.size() < 1) {
            throw new RuntimeException(String.format("Issues with title '%s' are not found in test run.", issueTitle));
        }
        if (issuesWithTitle.size() > 1) {
            throw new RuntimeException(String.format("Found more than one issue with title: '%s' in test run.", issueTitle));
        }
        return issuesWithTitle.get(0).getYoutrackId();
    }

    private String getIssueTitle(String issueId) {
        String path = String.format("/issues/%s?fields=id,idReadable,summary", issueId);

        return RestAssured.given().baseUri("https://vvrozhkova.myjetbrains.com/youtrack/api")
                .header("Authorization", "Bearer " + App.config.youtrackToken())
                .contentType(ContentType.JSON)
                .when()
                .get(path)
                .then()
                .statusCode(200)
                .extract().jsonPath().getString("summary");
    }
}

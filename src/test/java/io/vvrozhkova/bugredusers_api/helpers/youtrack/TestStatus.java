package io.vvrozhkova.bugredusers_api.helpers.youtrack;

public enum TestStatus {

    PASSED("Passed", "passed"),
    FAILED("Failed", "failed");

    private final String presentation, id;

    TestStatus(String presentation, String id) {
        this.presentation = presentation;
        this.id = id;
    }

    public String getPresentation() {
        return presentation;
    }

    public String getId() {
        return id;
    }
}

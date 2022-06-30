package io.vvrozhkova.bugredusers_api.api.companies;

public enum CompanyType {

    OOO("ООО"), OAO("ОАО"), IP("ИП");

    private final String type;

    CompanyType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

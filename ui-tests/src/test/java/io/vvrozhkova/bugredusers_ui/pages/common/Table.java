package io.vvrozhkova.bugredusers_ui.pages.common;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;

import java.util.Map;

import static com.codeborne.selenide.Selenide.element;

public abstract class Table {

    protected SelenideElement table;
    protected Map<String, Integer> columns;
    protected ElementsCollection rows;

    public Table(SelenideElement table, Map<String, Integer> columns) {
        this.table = table;
        this.columns = columns;
        this.rows = table.findAll("tbody tr");
    }

    public ElementsCollection getRows() {
        return rows;
    }

    public SelenideElement getFirstRowColumn(String column) {
        return getRowColumn(rows.first(), column);
    }

    public SelenideElement getRowColumn(WebElement row, String column) {
        return element(row).find("td:nth-child(" + columns.get(column) + ")");
    }

    public SelenideElement findRowWithValue(String column, String value) {
        return rows
                .find(Condition.match(
                        "row with " + column + " = " + value,
                        row -> getRowColumn(row, column).getText().equalsIgnoreCase(value))
                );
    }
}

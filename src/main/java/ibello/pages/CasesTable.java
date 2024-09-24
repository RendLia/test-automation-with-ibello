package ibello.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.elements.WebElements;
import hu.ibello.search.By;
import hu.ibello.search.Find;
import ibello.pages.component.TableComponent;

import java.time.LocalDate;
import java.util.regex.Pattern;

@Name("Ügyek táblázat")
public class CasesTable extends TableComponent {

    @Find(by = By.CSS_SELECTOR, using = "table")
    WebElement table;

    @Override
    protected WebElement get_table() {
        return table;
    }

    public void assume_that_case_name_in_last_row_is_$(String casename) {
        WebElement lastRow = get_last_row();
        WebElements cells = get_cells(lastRow);
        WebElement webElement = cells.get(2);
        expectations().assume(webElement).toHave().text(casename);
    }

    public void assume_that_person_in_last_row_is_$(String person) {
        WebElement lastRow = get_last_row();
        WebElements cells = get_cells(lastRow);
        WebElement webElement = cells.get(3);
        expectations().assume(webElement).toHave().text(person);
    }

    public void assume_that_validity_in_last_row_is_$(LocalDate validity) {
        WebElement lastRow = get_last_row();
        WebElements cells = get_cells(lastRow);
        WebElement webElement = cells.get(4);
        expectations().assume(webElement).toHave().text(validity.toString());
    }

    public void assume_that_id_in_last_row_is_$(String id) {
        WebElement lastRow = get_last_row();
        WebElements cells = get_cells(lastRow);
        WebElement webElement = cells.get(0);
        expectations().assume(webElement).toHave().text(id);
    }

    public void assume_that_status_in_last_row_is_$(String status) {
        WebElement lastRow = get_last_row();
        WebElements cells = get_cells(lastRow);
        WebElement webElement = cells.get(1);
        expectations().assume(webElement).toHave().text(status);
    }

    public void assume_that_responsible_in_last_row_is_$(String responsible) {
        WebElement lastRow = get_last_row();
        WebElements cells = get_cells(lastRow);
        WebElement webElement = cells.get(5);
        expectations().assume(webElement).toHave().text(responsible);
    }

    public void assume_that_last_row_has_id() {
        WebElement lastRow = get_last_row();
        WebElements cells = get_cells(lastRow);
        WebElement webElement = cells.get(0);
        Pattern pattern = Pattern.compile("^1[0-9]{7}");
        expectations().assume(webElement).toHave().text(pattern);
    }

    public void expect_that_table_has_$_number_of_cases(int count) {
        expect_that_table_has_rows(count);
    }

    public void click_on_case_with_$_id(String id) {
        WebElements links = table.find().using("a").all();
        for (WebElement link : links) {
            if (get(link).text().equals(id)) {
                doWith(link).click();
                return;
            }
        }
    }

    private WebElements get_cells(WebElement row) {
        return row.find().using("td").all();
    }
}


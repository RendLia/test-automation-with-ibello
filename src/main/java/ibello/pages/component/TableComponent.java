package ibello.pages.component;

import hu.ibello.elements.WebElement;
import hu.ibello.elements.WebElements;
import hu.ibello.pages.PageObject;
import hu.ibello.search.By;
import hu.ibello.search.Find;

public class TableComponent extends PageObject {

    @Find(by = By.CSS_SELECTOR, using = "table")
    WebElement table;

    protected WebElement get_table() {
        return table;
    }

    protected WebElement get_last_row() {
        WebElements rows = get_body_rows();
        return rows.get(rows.size()-1);
    }

    protected void expect_that_table_has_rows(int count) {
        WebElements rows = get_body_rows();
        expectations().expect(rows).toHave().size(count);
    }

    private WebElements get_body_rows() {
        return get_table().find().using("tbody tr").all();
    }
}

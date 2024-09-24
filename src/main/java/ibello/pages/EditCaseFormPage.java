package ibello.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;
import hu.ibello.search.Relation;
import hu.ibello.search.RelationType;

@Name("Edit Case Form Page")
public class EditCaseFormPage extends AbstractFormPage {

    @Find(by = By.PARTIAL_TEXT, using = "Ügy ")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "panel-heading")
    private WebElement cím;

    public void page_must_be_loaded() {
        expectations().expect(cím).toBe().displayed();
    }

    public void assume_that_title_contains_$_id(String id) {
        WebElement cím = this.cím.find().using(By.CSS_SELECTOR, "h3").first();
        expectations().assume(cím).toHave().text("Ügy "+id);
    }

    public boolean is_status_editable() {
        return checkThat(statusField).isReadonly();
    }
}

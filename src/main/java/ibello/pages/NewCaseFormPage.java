package ibello.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.search.By;
import hu.ibello.search.Find;
import hu.ibello.search.Relation;
import hu.ibello.search.RelationType;

@Name("New Case Form Page")
public class NewCaseFormPage extends AbstractFormPage {

    @Find(by = By.TEXT, using = "Új ügy")
    @Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "panel-heading")
    private WebElement title;

    public void page_must_be_loaded() {
        expectations().expect(title).toBe().displayed();
    }
    public void assume_that_status_is_editable(){
        expectations().assume(statusField).toBe().readonly();
    }
    public void assume_that_status_is_$(String status) {
        expectations().assume(statusField).toHave().selectedOption(status);
    }
}


package ibello.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.pages.PageObject;
import hu.ibello.search.By;
import hu.ibello.search.Find;
import hu.ibello.search.Relation;
import hu.ibello.search.RelationType;

@Name("Cases Page")
public class CasesPage extends PageObject {

	@Find(by = By.TEXT, using = "Ügyek")
	@Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "panel-heading")
	private WebElement cím;

	@Find(by = By.BUTTON_TEXT, using = "Új ügy")
	private WebElement újÜgyButton;

	//tábla elem azonosítás 1-n esetre. érték tárolás. List? Arrylist? Csoprtosítási opciók?

	public void page_must_be_loaded() {
		expectations().expect(cím).toBe().displayed();
	}

	public void click_on_new_case_button() {
		doWith(újÜgyButton).click();
	}

}
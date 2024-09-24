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

	@Find(by = By.BUTTON_TEXT, using = "${demo.new.case.button}")
	private WebElement újÜgyButton;

	@Find(by = By.BUTTON_TEXT, using = "${demo.home.button}")
	private WebElement demóLink;

	@Find(by = By.BUTTON_TEXT, using = "${demo.cases.button}")
	private WebElement ügyekLink;

	@Find(by = By.BUTTON_TEXT, using = "${demo.new.case.button}")
	private WebElement újÜgyLink;

	@Find(by = By.BUTTON_TEXT, using = "Teszt Elek")// TODO Hogy lehetne Teszt Áron-z is használni?
	private WebElement userLink;

	public void page_must_be_loaded() {
		expectations().expect(cím).toBe().displayed();
	}

	public boolean is_page_loaded() {
		//return browser().getURL().equals(URL); // alternatívája a lentinek
		return checkThat(cím).isDisplayed();
	}

	public void click_on_new_case_button() {
		doWith(újÜgyButton).click();
	}

	public void click_on_user_name() {
		doWith(userLink).click();
	}
}
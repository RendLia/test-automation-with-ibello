import hu.ibello.elements.WebElement;
import hu.ibello.pages.PageObject;
import hu.ibello.search.By;
import hu.ibello.search.Find;

public class CaseFormPage extends PageObject {

	@Find(by = By.ID, using = "name")
	private WebElement nameField;

	@Find(by = By.ID, using = "status")
	private WebElement statusField;

	@Find(by = By.ID, using = "validity")
	private WebElement validityField;

	@Find(by = By.ID, using = "person")
	private WebElement personField;

	@Find(by = By.ID, using = "city")
	private WebElement cityField;

	@Find(by = By.ID, using = "zipCode")
	private WebElement zipCodeField;

	@Find(by = By.ID, using = "street")
	private WebElement streetField;

	@Find(by = By.ID, using = "number")
	private WebElement numberField;

	@Find(by = By.ID, using = "responsible")
	private WebElement responsibleField;

	@Find(by = By.BUTTON_TEXT, using = "Mentés")
	private WebElement mentésButton;

	@Find(by = By.BUTTON_TEXT, using = "Mégsem")
	private WebElement mégsemButton;

}
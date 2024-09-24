package ibello.pages;

import hu.ibello.elements.WebElement;
import hu.ibello.pages.PageObject;
import hu.ibello.search.By;
import hu.ibello.search.Find;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class AbstractFormPage extends PageObject {

	@Find(by = By.ID, using = "name")
	private WebElement nameField;

	@Find(by = By.ID, using = "status")//?? nem vagyok benne bbiztos hogy ez igy okés új és szerkesztéskor egyedi a működése
	protected static WebElement statusField;

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

	@Find(by = By.BUTTON_TEXT, using = "${demo.save.button}")
	private WebElement mentésButton;

	@Find(by = By.BUTTON_TEXT, using = "${demo.cancel.button}")
	private WebElement mégsemButton;

	public void set_casename_to_$(String casename) {
		doWith(nameField).setValue(casename);
	}

	public void set_status_to_$(String status) {
		doWith(statusField).setValue(status);
	}

	public void set_valitity_to_$(LocalDate validity) {
		int year = validity.getYear();
		int month = validity.getMonthValue();
		int dayOfMonth = validity.getDayOfMonth();

		doWith(validityField).sendKeys(String.valueOf(year));
		doWith(validityField).sendKeys(keys().RIGHT);
		doWith(validityField).sendKeys(String.valueOf(month));
		doWith(validityField).sendKeys(String.valueOf(dayOfMonth));
	}

	public void set_person_to_$(String person) {
		doWith(personField).setValue(person);
	}

	public void set_city_to_$(String city) {
		doWith(cityField).setValue(city);
	}

	public void set_zipcode_to_$(int zipcode) {
		String code = String.valueOf(zipcode);
		doWith(zipCodeField).setValue(code);
	}

	public void set_street_to_$(String street) {
		doWith(streetField).setValue(street);
	}

	public void set_number_to_$(String number) {
		doWith(numberField).setValue(number);
	}

	public void assume_that_responsible_is_readonly() {
		expectations().assume(responsibleField).toBe().readonly();
	}

	public void assume_that_responsible_field_is_not_empty() {
		Pattern p = Pattern.compile("\\w");
		expectations().assume(responsibleField).toHave().value(p);
	}

	public void click_on_save_button() {
		doWith(mentésButton).click();
	}

	public void click_on_cancel_button() {
		doWith(mégsemButton).click();
	}
}
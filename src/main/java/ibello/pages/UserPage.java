package ibello.pages;

import hu.ibello.elements.WebElement;
import hu.ibello.pages.PageObject;
import hu.ibello.search.By;
import hu.ibello.search.Find;
import hu.ibello.search.Relation;
import hu.ibello.search.RelationType;

public class UserPage extends PageObject {

	@Find(by = By.TEXT, using = "Felhasználó")
	@Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "panel-heading")
	private WebElement cím;

	@Find(by = By.ID, using = "username")
	private WebElement usernameField;

	@Find(by = By.ID, using = "fullName")
	private WebElement fullNameField;

	@Find(by = By.ID, using = "currentPassword")
	private WebElement currentPasswordField;

	@Find(by = By.ID, using = "password")
	private WebElement passwordField;

	@Find(by = By.ID, using = "password2")
	private WebElement formControlField;

	@Find(by = By.BUTTON_TEXT, using = "${demo.password.update.button}")
	private WebElement jelszóVáltoztatásButton;

	public void page_must_be_loaded() {
		expectations().expect(cím).toBe().displayed();
	}

	public void assume_user_name_should_be_readonly() {
		expectations().assume(usernameField).toBe().readonly();
	}

	public void assume_full_user_name_should_be_readonly() {
		expectations().assume(fullNameField).toBe().readonly();
	}

	public void set_current_password_field_with_$(String currentpass) {
		doWith(currentPasswordField).setValue(currentpass);
	}

	public void set_new_password_field_with_$(String newpass) {
		doWith(passwordField).setValue(newpass);
	}

	public void set_new_pw_control_field_with_$(String newpass) {
		doWith(formControlField).setValue(newpass);
	}

	public void click_on_new_case_button() {
		doWith(jelszóVáltoztatásButton).click();
	}

}
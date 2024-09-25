package ibello.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.pages.PageObject;
import hu.ibello.search.By;
import hu.ibello.search.Find;
import hu.ibello.search.Relation;
import hu.ibello.search.RelationType;

@Name("User")
public class UserPage extends PageObject {

	private static final String CURRENTPW_ERROR_MSG = "A jelenlegi jelszó hibás.";
	private static final String NEW2PW_ERROR_MSG = "A jelszavak nem egyeznek meg.";

	@Find(by = By.TEXT, using = "Felhasználó")
	@Relation(type = RelationType.DESCENDANT_OF, by = By.CLASS_NAME, using = "panel-heading")
	private WebElement title;

	@Find(by = By.ID, using = "username")
	private WebElement usernameField;

	@Find(by = By.ID, using = "fullName")
	private WebElement fullNameField;

	@Find(by = By.ID, using = "currentPassword")
	private WebElement currentPasswordField;

	@Find(by = By.ID, using = "password")
	private WebElement passwordField;

	@Find(by = By.ID, using = "password2")
	private WebElement password2Field;

	@Find(by = By.BUTTON_TEXT, using = "${demo.password.update.button}")
	private WebElement passwordChangeButton;

	@Find(by = By.CLASS_NAME, using = "error")
	private WebElement error;

	public void page_must_be_loaded() {
		expectations().expect(title).toBe().displayed();
	}

	public void assume_that_user_name_is_readonly() {
		expectations().assume(usernameField).toBe().readonly();
	}

	public void assume_that_full_user_name_is_readonly() {
		expectations().assume(fullNameField).toBe().readonly();
	}

	public void set_current_password_field_with_$(String currentpass) {
		doWith(currentPasswordField).setValue(currentpass);
	}

	public void set_new_password_field_with_$(String newpass) {
		doWith(passwordField).setValue(newpass);
	}

	public void set_new_password2_field_with_$(String newpass2) {
		doWith(password2Field).setValue(newpass2);
	}

	public void click_on_password_change_button() {
		doWith(passwordChangeButton).click();
	}

	public void assume_that_current_pw_error_message_is_displayed() {
		expectations().assume(error).toHave().text(CURRENTPW_ERROR_MSG);
	}

	public void assume_that_second_pw_error_message_is_displayed() {
		expectations().assume(error).toHave().text(NEW2PW_ERROR_MSG);
	}
}
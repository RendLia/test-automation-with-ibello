package ibello.pages;

import hu.ibello.core.Name;
import hu.ibello.elements.WebElement;
import hu.ibello.pages.PageObject;
import hu.ibello.search.By;
import hu.ibello.search.Find;

@Name("Login page")
public class LoginPage extends PageObject {

    private static final String URL = "https://ibello.hu/tasks/cases/#/login";
    private static final String LOGIN_ERROR_MSG = "A felhasználói név és/vagy jelszó nem megfelelő.";

    @Find(by = By.ID, using = "username")
    private WebElement usernameField;

    @Find(by = By.ID, using = "password")
    private WebElement passwordField;

    @Find(by = By.BUTTON_TEXT, using = "${demo.login.button}")
    private WebElement loginButton;
    
    @Find(by = By.CLASS_NAME, using = "error")
    private WebElement error;

    public void open_demo_page() {
        browser().openURL(URL);
        browser().resize(1920, 1080);
        browser().maximize();
    }

    public void page_must_be_loaded() {
        expectations().expect(usernameField).toBe().displayed();
        expectations().expect(passwordField).toBe().displayed();
    }

    public boolean is_page_loaded() {
        return browser().getURL().equals(URL); // alternatívája a lentinek
        //return checkThat(usernameField).isDisplayed();
    }

    public boolean is_application_open(){
        return browser().getURL().contains("ibello.hu");
    }

    public void click_on_login_button() {
        doWith(loginButton).click();
    }

    public void set_username_to_$(String username) {
        doWith(usernameField).setValue(username);
    }

    public void set_password_to_$(String password) {
        doWith(passwordField).setValue(password);
    }
    
    public void error_message_should_be_displayed() {
        expectations().assume(error).toBe().displayed();
    }
    
    public void login_error_message_should_be_displayed() {
        expectations().assume(error).toHave().text(LOGIN_ERROR_MSG);
    }

    public boolean is_error_msg_displayed() {
        if (checkThat(error).isDisplayed()) {
            String errorMsg = get(error).text();
            return errorMsg.equals(LOGIN_ERROR_MSG);
        }
        return false;
    }

    public void change_url_for_logout() {
        browser().openURL(URL);
    }
}

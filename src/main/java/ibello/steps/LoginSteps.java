package ibello.steps;

import hu.ibello.core.Name;
import hu.ibello.steps.StepLibrary;
import ibello.pages.CasesPage;
import ibello.pages.LoginPage;

@Name("Login steps")
public class LoginSteps extends StepLibrary{

    private static final String LOGIN_ERROR_MSG = "A felhasználói név és/vagy jelszó nem megfelelő.";
    private LoginPage loginPage;
    private CasesPage casesPage;
    
    public void open_demo_application() {
        loginPage.open_demo_page();
        loginPage.page_must_be_loaded();
    }
    
    public void enter_$_username(String username) {
        loginPage.set_username_to_$(username);
    }
    
    public void enter_$_password(String password) {
        loginPage.set_password_to_$(password);
    }
    
    public void attempt_to_login() {
        loginPage.click_on_login_button();
    }
    
    public void cases_page_is_loaded() {
        casesPage.page_must_be_loaded();
    }

    public void error_message_is_displayed() {
        loginPage.error_message_should_be_displayed();
        loginPage.$_error_message_should_be_displayed(LOGIN_ERROR_MSG);
    }
    
    @Name("login with ${0} user")
    public void login_with_$_user(String username, String password) {
        open_demo_application();
        enter_$_username(username);
        enter_$_password(password);
        attempt_to_login();
        cases_page_is_loaded();
    }
    
}

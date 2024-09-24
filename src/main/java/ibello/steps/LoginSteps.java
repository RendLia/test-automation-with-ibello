package ibello.steps;

import hu.ibello.core.Name;
import hu.ibello.steps.StepLibrary;
import ibello.pages.CasesPage;
import ibello.pages.LoginPage;

@Name("Login steps")
public class LoginSteps extends StepLibrary{

    private LoginPage loginPage;
    private CasesPage casesPage;
    
    public void open_demo_application() {
        if (!loginPage.is_page_loaded()) {
            loginPage.open_demo_page();
        }
        loginPage.page_must_be_loaded();
    }
    
    public void enter_valid_username() {
        String username = getConfigurationValue("demo.app.username").toString();
        loginPage.set_username_to_$(username);
    }

    public void enter_valid_password() {
        String password = getConfigurationValue("demo.app.password").toString();
        loginPage.set_password_to_$(password);
    }

    public void enter_invalid_password() {
        loginPage.set_password_to_$("3s4d5f6");
    }
    
    public void attempt_to_login() {
        loginPage.click_on_login_button();
    }
    
    public void cases_page_is_loaded() {
        casesPage.page_must_be_loaded();
    }

    public void error_message_is_displayed() {
        loginPage.error_message_should_be_displayed();
        loginPage.login_error_message_should_be_displayed();
    }
    
    public void login_with_valid_user() {
        if (!casesPage.is_page_loaded()){//TODO nem jött össze az iteráció újra kell gondolnom
            enter_valid_username();
            enter_valid_password();
            attempt_to_login();
        }
        cases_page_is_loaded();
    }

    public void login_with_invalid_password() {
        if (!loginPage.is_error_msg_displayed()) {
            open_demo_application();
            enter_valid_username();
            enter_invalid_password();
            attempt_to_login();
            error_message_is_displayed();
            loginPage.page_must_be_loaded();
        } else {
            output().recordCustomAction("Már korábban megtörtént");
        }
    }

    public void logout() {
        loginPage.change_url_for_logout();
        loginPage.page_must_be_loaded();
    }
}

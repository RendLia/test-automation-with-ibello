package ibello.steps;

import hu.ibello.core.Name;
import hu.ibello.steps.StepLibrary;
import ibello.pages.NavPanel;
import ibello.pages.UserPage;

@Name("User")
public class UserSteps extends StepLibrary {

    private UserPage userPage;
    private NavPanel navPanel;

    public void user_page_is_loaded() {
        userPage.page_must_be_loaded();
    }

    public void user_name_should_be_readonly() {
        userPage.assume_that_user_name_is_readonly();
    }

    public void full_user_name_should_be_readonly(){
        userPage.assume_that_full_user_name_is_readonly();
    }

    public void set_current_password_$(String currentpw) {
        userPage.set_current_password_field_with_$(currentpw);
    }

    public void set_first_new_password_$(String newpass){
        userPage.set_new_password_field_with_$(newpass);
    }

    public void set_second_new_password_$(String newpass2) {
        userPage.set_new_password2_field_with_$(newpass2);
    }

    public void assume_that_current_pw_error_msg_should_be_display() {
        userPage.assume_that_current_pw_error_message_is_displayed();
    }

    public void assume_that_second_pw_error_msg_should_be_display() {
        userPage.assume_that_second_pw_error_message_is_displayed();
    }

    public void save_the_modification() {
        userPage.click_on_password_change_button();
    }

    public void navigate_user_page() {
        navPanel.click_on_user_name();
        user_page_is_loaded();
    }
}

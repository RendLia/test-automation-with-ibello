package ibello.workflows;

import hu.ibello.core.Name;
import hu.ibello.steps.StepLibrary;
import ibello.steps.CasesSteps;
import ibello.steps.LoginSteps;
import ibello.steps.UserSteps;

@Name("User")
public class UserWorkflow extends StepLibrary {

    private CasesSteps casesSteps;
    private UserSteps userSteps;
    private LoginSteps loginSteps;
    private String currentpw;
    private String newpass;

    public void a_felhasználó_a_felhasználói_oldalon_van() {
        loginSteps.login_to_cases_page();
        userSteps.navigate_user_page();
    }

    public void a_felhasználó_ellenőrzi_a_név_adatokat() {
        output().recordCustomAction("Az automatának itt nem kell semmit csinálnia");
    }

    public void a_felhasználói_név_csak_olvasható_módon_jelenik_meg() {
        userSteps.user_name_should_be_readonly();
    }

    public void a_teljes_név_csak_olvasható_módon_jelenik_meg() {
        userSteps.full_user_name_should_be_readonly();
    }

    public void a_felhasználó_helyesen_megadja_a_jelenlegi_jelszavát() {
        currentpw = getConfigurationValue("demo.app.password").toString();
        userSteps.set_current_password_$(currentpw);
    }

    public void a_felhasználó_kétszer_megadja_az_új_érvényes_jelszavát() {
        newpass = "Newpw123";
        userSteps.set_first_new_password_$(newpass);
        userSteps.set_second_new_password_$(newpass);
    }

    public void a_felhasználó_menti_a_módosítást() {
        userSteps.save_the_modification();
    }

    public void a_jelszó_módosítása_sikeres() {
        loginSteps.logout();
        String username = getConfigurationValue("demo.app.username").toString();
        loginSteps.login_with_$_username_and_$_password(username, newpass);
    }

    public void a_felhasználó_hibásan_megadja_a_jelenlegi_jelszavát() {
        userSteps.set_current_password_$("2345tzh");
    }

    public void a_jelenlegi_jelszóval_kapcsolatos_hiba_üzenet_jelenik_meg() {
        userSteps.assume_that_current_pw_error_msg_should_be_display();
    }

    public void a_jelszó_módosítása_sikertelen() {
        loginSteps.logout();
        loginSteps.login_with_valid_user();
    }

    public void a_felhasználó_csak_egyszer_adja_meg_helyesen_az_új_érvényes_jelszavát() {
        newpass = "Newpw123";
        userSteps.set_first_new_password_$(newpass);
        userSteps.set_second_new_password_$("34567");
    }

    public void az_új_jelszóval_kapcsolatos_hiba_üzenet_jelenik_meg() {
        userSteps.assume_that_second_pw_error_msg_should_be_display();
    }

}

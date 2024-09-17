package ibello.workflows;

import hu.ibello.core.Name;
import hu.ibello.steps.StepLibrary;
import ibello.steps.LoginSteps;

@Name("Login")
public class LoginWorkflow extends StepLibrary {
    
    private LoginSteps loginSteps;

    // 1.
    public void a_felhasználó_a_bejelentkezési_felületen_van() {
        loginSteps.open_demo_application();
    }

    public void a_felhasználó_érvényes_felhasználói_nevet_ad_meg() {
        String username = getConfigurationValue("demo.app.username").toString();
        loginSteps.enter_$_username(username);
    }

    public void a_felhasználó_érvényes_jelszót_ad_meg() {
        String password = getConfigurationValue("demo.app.password").toString();
        loginSteps.enter_$_password(password);
    }

    public void a_felhasználó_megpróbál_bejelentkezni() {
        loginSteps.attempt_to_login();
    }

    public void a_bejelentkezés_sikeres() {
        // Nothing to do
    }

    public void a_felhasználó_a_főoldalra_érkezik() {
        loginSteps.cases_page_is_loaded();
    }
    
    // 2.
    public void a_felhasználó_érvénytelen_jelszót_ad_meg() {
        loginSteps.enter_$_password("3s4d5f6");
    }
    
    public void a_bejelentkezés_sikertelen() {
     // Másik teszt lépés lefedi
    }
    
    public void a_felhasználó_érvénytelen_felhasználói_adatokkal_kapcsolatos_hibaüzenetet_kap() {
        loginSteps.error_message_is_displayed();
    }

    public void sikertelen_belépés_után__a_felhasználó_még_a_belépés_oldalon_van() {
        String username = getConfigurationValue("demo.app.username").toString();
        loginSteps.login_with_error(username);

    }

    public void a_felhasználó_érvényes_adatokkal_próbál_meg_belépni() {
        String username = getConfigurationValue("demo.app.username").toString();
        String password = getConfigurationValue("demo.app.password").toString();
        loginSteps.login_with_$_user(username,password);
    }

}

package ibello.workflows;

import hu.ibello.core.Name;
import hu.ibello.steps.StepLibrary;
import ibello.model.Address;
import ibello.model.Case;
import ibello.model.DefaultData;
import ibello.steps.CasesSteps;
import ibello.steps.LoginSteps;

@Name("Cases")
public class CasesWorkflow extends StepLibrary {

    private CasesSteps casesSteps;
    private Case caseData;
    private LoginSteps loginSteps;
    private int casesCount;

    public void a_felhasználó_az_új_ügy_rögzítési_felületen_van() {
        loginSteps.open_demo_application();
        loginSteps.login_with_valid_user();
        casesSteps.create_new_case();
        casesSteps.new_case_page_is_loaded();
    }

    public void a_felhasználó_kitöltötte_az_összes_adatot() {
        caseData = testData().fromJson(Case.class).withId("tomorrow").load();
        casesSteps.fill_all_field_with_$_data(caseData);
    }

    public void a_felhasználó_a_holnapi_napot_adja_meg_érvényességi_időnek() {
        output().recordCustomAction("Az előző lépésben helyes tesztadat lett átadva ");
    }

    public void a_felhasználó_elmenti_az_új_ügyet() {
        casesSteps.user_save_case();
    }

    public void a_felhasználó_visszatér_az_ügyek_oldalra() {
        casesSteps.cases_page_is_loaded();
    }

    public void az_új_ügy_egyedi_azonosítóval_megjelenik_az_ügyek_táblázatban() {
        casesSteps.assume_that_case_appears_in_table(caseData);
        casesSteps.assume_that_new_id_appear();
    }

    public void legalább_egy_ügy_van_a_rendszerben() {
        casesCount=4;
        caseData = testData().fromJson(Case.class).withId("1").load();
    }

    public void a_felhasználó_az_ügyek_oldalon_van() {
        loginSteps.open_demo_application();
        loginSteps.login_with_valid_user();
        casesSteps.cases_page_is_loaded();
    }

    public void a_felhasználó_ellenőrzi_a_megjelent_ügyek_adatait() {
        output().recordCustomAction("Az előző lépésen végrehajtva");
    }

    public void minden_ügy_megjelenik_egy_táblában() {
        casesSteps.expect_that_table_has_$_number_of_cases(casesCount);
    }

    public void megjelenik_az_ügy_azonosítója() {
        casesSteps.assume_that_case_appears_in_table(caseData);
    }

    public void megjelenik_az_ügy_állapota() {
        output().recordCustomAction("Az előző lépés leellenőrzi");
    }

    public void megjelenik_az_ügy_megnevezése() {
        output().recordCustomAction("Az előző lépés leellenőrzi");
    }

    public void megjelenik_az_ügy_személye() {
        output().recordCustomAction("Az előző lépés leellenőrzi");
    }

    public void megjelenik_az_ügy_érvényessége() {
        output().recordCustomAction("Az előző lépés leellenőrzi");
    }

    public void megjelenik_az_ügy_felelőse() {
        output().recordCustomAction("Az előző lépés leellenőrzi");
    }

    public void a_felhasználó_kezdeményezi_egy_új_ügy_létrehozását() {
        casesSteps.create_new_case();
    }

    public void az_új_ügy_oldal_megjelenik() {
        casesSteps.new_case_page_is_loaded();
    }

    public void az_ügy_állapota_új() {
        //TODO nem jó az érték átadás
        casesSteps.case_status_is_new();
    }

    public void az_állapot_nem_szerkeszthető() {
        casesSteps.status_is_readonly();
    }

    public void az_ügy_felelőse_ki_van_töltve() {
        // TODO nincs a html kódban mit validálni
        casesSteps.responsible_is_not_empty();
    }

    public void a_felhasználó_megszakítja_az_ügy_létrehozását() {
        casesSteps.user_cancel_case_created();
    }

    public void új_ügy_nem_jelenik_meg_a_listában() {
        casesCount=4;
        casesSteps.expect_that_table_has_$_number_of_cases(casesCount);
    }

    public void a_felhasználó_megnyitja_szerkesztésre_az_ügyet() {
        casesSteps.open_case_with_$_id(caseData.getId());
    }

    public void a_felhasználó_az_ügy_oldalára_jut() {
        casesSteps.edit_form_case_is_loaded();
    }

    public void az_ügy_azonosítója_megjelenik() {
        //TODO nem fűzi össze az ügyet meg az idt
        casesSteps.assume_that_$_id_is_on_case_form(caseData.getId());
    }

    public void az_ügy_felelőse_megjelenik() {
        // TODO  nincs a html kódban mit validálni
        casesSteps.responsible_is_not_empty();
    }

    public void a_két_érték_nem_módosítható() {
        casesSteps.responsible_is_not_editable();
        // TODO a fejléc szereszthetetlensége
    }

    public void a_felhasználó_egy_meglévő_ügy_oldalán_van() {
        loginSteps.open_demo_application();
        loginSteps.login_with_valid_user();
        casesSteps.cases_page_is_loaded();
        casesSteps.open_case_with_$_id(caseData.getId());
        casesSteps.edit_form_case_is_loaded();
    }

    public void a_felhasználó_módosítja_a_ügy_alapadatait() {
        DefaultData ddedit = testData().fromJson(DefaultData.class).withId("ddedit").load();
        casesSteps.fill_default_field_to_$(ddedit);

    }

    public void az_ügy_módosítás_nélkül_jelenik_meg() {
        caseData = testData().fromJson(Case.class).withId("1").load();
        casesSteps.assume_that_case_appears_in_table(caseData);
    }

    public void a_felhasználó_módosítja_az_ügy_cím_adatait() {
        Address edit = testData().fromJson(Address.class).withId("edit").load();
        casesSteps.fill_address_field_to_$(edit);
    }

    public void a_felhasználó_módosítja_az_ügy_alapadatait() {
        DefaultData ddedit = testData().fromJson(DefaultData.class).withId("ddedit").load();
        casesSteps.fill_default_field_to_$(ddedit);
    }

    public void a_felhasználó_elmenti_az_ügyet() {
        casesSteps.user_save_case();
    }

    public void az_ügy_módosításai_megjelenek_az_ügyek_táblázatban() {
        DefaultData ddedit = testData().fromJson(DefaultData.class).withId("ddedit").load();
        casesSteps.assume_that_updated_data_appear_in_table(ddedit);
    }
}
